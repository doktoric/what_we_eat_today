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
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
public class KompotParser extends AbstractRestaurantParser {

    @Override
    public Object getMenu() throws IOException {
        List<DailyMenu> menus = new ArrayList<DailyMenu>();
        Elements elements = this.getDocument().select("table").select("tr");
        for (int i = 0; i < 5; i++) {
            Element day = elements.get(i).select("td").get(0).child(0);
            Element soup = elements.get(i).select("td").get(1).child(0);
            Element mainDish = elements.get(i).select("td").get(1).child(1);
            DailyMenu menu = new DailyMenu.Builder()
                    .withDay(day.text())
                    .withDessert("")
                    .withMainDish(mainDish.text())
                    .withAppetizer(soup.text())
                    .build();
            menus.add(menu);
        }
        return menus;
    }

    @Override
    protected String getResponseUrl() throws IOException {
        return Restaurant.KOMPOT.getUrl();
    }
}
