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
 * Time: 20:05
 * To change this template use File | Settings | File Templates.
 */
public class FiktivParser extends AbstractRestaurantParser {

    @Override
    public Object getMenu() throws IOException {
        List<DailyMenu> menus = new ArrayList<DailyMenu>();
        Elements elements = this.getDocument().select(".htmltext");
        for (int i = 0; i < DAYS.length; i++) {
            Element day = elements.select("p:contains(" + DAYS[i] + ")").first();
            Element appetizer = day.nextElementSibling();
            Element mainDish = appetizer.nextElementSibling();

            DailyMenu menu = new DailyMenu.Builder()
                    .withDay(DAYS[i])
                    .withDessert("")
                    .withMainDish(mainDish.text())
                    .withAppetizer(appetizer.text())
                    .build();
            menus.add(menu);

        }
        return menus;
    }

    @Override
    protected String getResponseUrl() throws IOException {
        return Restaurant.FIKTIV.getUrl();
    }
}
