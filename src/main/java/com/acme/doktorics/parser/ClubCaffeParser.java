package com.acme.doktorics.parser;

import com.acme.doktorics.domain.DailyMenu;
import com.acme.doktorics.domain.Restaurant;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 20:05
 * To change this template use File | Settings | File Templates.
 */
public class ClubCaffeParser extends AbstractRestaurantParser {

    @Override
    public Object getMenu() throws IOException {

        return new ArrayList<DailyMenu>();
    }

    @Override
    protected String getResponseUrl() throws IOException {
        return Restaurant.CLUBCAFFE.getUrl();
    }
}
