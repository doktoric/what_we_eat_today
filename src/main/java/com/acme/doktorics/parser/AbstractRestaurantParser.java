package com.acme.doktorics.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractRestaurantParser implements BaseRestaurantParser {

    protected String[] DAYS = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek"};
    protected String[] SOUP = {"Leves", "leves", "LEVES"};

    protected Document getDocument() throws IOException {
        String responseUrl = getResponseUrl();
        return Jsoup.connect(responseUrl).timeout(10 * 1000).get();
    }

    protected byte[] getDocumentAsByte() throws IOException {
        return getDocument().text().getBytes();
    }

    public abstract Object getMenu() throws IOException;

    protected abstract String getResponseUrl() throws IOException;

    protected boolean isSoup(String text) {
        boolean isSoup = false;
        for (String soup : SOUP) {
            if (text.contains(soup)) {
                isSoup = true;
            }
        }
        return isSoup;
    }

    protected String getMainDish(List<String> foods, int begin, int end) {
        String result = "";
        for (int i = begin; i < end; i++) {
            result += foods.get(i) + " ";
        }
        return result.trim();
    }

    protected boolean isEmpty(Element element) {
        String text = element
                .text()
                .replaceAll(String.valueOf((char) 160), " ")
                .trim();
        if (text.equals("")) {
            return true;
        }
        return false;
    }

}
