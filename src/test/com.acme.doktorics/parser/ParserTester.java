package com.acme.doktorics.parser;

import com.acme.doktorics.domain.DailyMenu;
import com.acme.doktorics.parser.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
public class ParserTester {
    BaseRestaurantParser fiktivParser = new FiktivParser();
    BaseRestaurantParser clubCaffeParser = new ClubCaffeParser();
    BaseRestaurantParser kompotParser = new KompotParser();
    BaseRestaurantParser stexParser = new StexParser();
    BaseRestaurantParser tenMinutesParser = new TenMinutesParser();

    @Test
    public void testFiktiv() throws IOException {
        List<DailyMenu> menus = (List<DailyMenu>) fiktivParser.getMenu();
        for (DailyMenu menu : menus) {
            System.out.println(menu.toString());
        }
    }

    @Test
    public void testStex() throws IOException {
        List<DailyMenu> menus = (List<DailyMenu>) stexParser.getMenu();
        for (DailyMenu menu : menus) {
            System.out.println(menu.toString());
        }
    }

    @Test
    public void testTenMinutes() throws IOException {
        Object menus = tenMinutesParser.getMenu();
        System.out.println(menus);
    }

    @Test
    public void testKompot() throws IOException {
        List<DailyMenu> menus = (List<DailyMenu>) kompotParser.getMenu();
        for (DailyMenu menu : menus) {
            System.out.println(menu.toString());
        }
    }
}
