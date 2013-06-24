package com.acme.doktorics.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 20:02
 * To change this template use File | Settings | File Templates.
 */
public enum Restaurant {
    FIKTIV("http://www.fiktivpub.hu/csak-most-csak-nalunk/heti-menu/62/"),
    KOMPOT("http://kompotbisztro.hu/etlap"),
    TENMINUTES("http://10minutes.hu/images/home_1_06.png"),
    CLUBCAFFE("https://www.facebook.com/pages/The-Club-Cafe-Bar-Kitchen/168956843129213"),
    STEX("http://www.stexhaz.hu/napimenu");

    private String url;

    private Restaurant(String url) {
        this.url = url;
    }

    private Restaurant() {
        this("");
    }

    public String getUrl() {
        return url;
    }
}
