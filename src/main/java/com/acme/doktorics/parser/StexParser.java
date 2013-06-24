package com.acme.doktorics.parser;

import com.acme.doktorics.domain.DailyMenu;
import com.acme.doktorics.domain.Restaurant;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 */
public class StexParser extends AbstractRestaurantParser {
    @Override
    public Object getMenu() throws IOException {
        List<DailyMenu> menus = new ArrayList<DailyMenu>();
        Elements elements = this.getDocument().select(".art-article").get(2).getAllElements();
        for (int i = 0; i < DAYS.length; i++) {
            Element day = elements.select("h2:contains(" + DAYS[i] + ")").first();
            List<String> foods = new ArrayList<String>();
            Element nextFood = day.nextElementSibling();
            if (i == DAYS.length - 1) {
                while (nextFood != null) {
                    if (!isEmpty(nextFood)) {
                        foods.add(nextFood.text());
                    }
                    nextFood=nextFood.nextElementSibling();

                }
            } else {
                while (!nextFood.text().equals(DAYS[i + 1])) {
                    foods.add(nextFood.text());
                    nextFood = nextFood.nextElementSibling();
                }
            }
            DailyMenu menu = new DailyMenu.Builder()
                    .withDay(DAYS[i])
                    .withDessert(foods.get(foods.size() - 1))
                    .withMainDish(getMainDish(foods, 1, foods.size() - 1))
                    .withAppetizer(foods.get(0))
                    .build();
            menus.add(menu);
        }
        return menus;
    }

    @Override
    protected String getResponseUrl() throws IOException {
        return Restaurant.STEX.getUrl();
    }
}
