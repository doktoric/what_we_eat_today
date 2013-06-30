package com.acme.doktorics.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 20:02
 * To change this template use File | Settings | File Templates.
 */
public enum Restaurant {
    FIKTIV("FIKTIV", "http://www.fiktivpub.hu/csak-most-csak-nalunk/heti-menu/62/"),
    KOMPOT("KOMPOT", "http://kompotbisztro.hu/etlap"),
    TENMINUTES("TENMINUTES", "http://10minutes.hu/images/home_1_06.png"),
    CLUBCAFFE("CLUBCAFFE", "https://www.facebook.com/pages/The-Club-Cafe-Bar-Kitchen/168956843129213"),
    STEX("STEX", "http://www.stexhaz.hu/napimenu");

    private String url;
    private String name;

    private Restaurant(String name, String url) {
        this.name=name;
        this.url = url;
    }

    private Restaurant() {
        this("", "");
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public static Restaurant getRestaurantByName(String restaurant) {
        if (restaurant.equals(FIKTIV.getName())) {
            return FIKTIV;
        } else if (restaurant.equals(KOMPOT.getName())) {
            return KOMPOT;
        } else if (restaurant.equals(TENMINUTES.getName())) {
            return TENMINUTES;
        } else if (restaurant.equals(CLUBCAFFE.getName())) {
            return CLUBCAFFE;
        } else {
            return STEX;
        }

    }
}


