package com.acme.doktorics.parser;

import com.acme.doktorics.domain.Restaurant;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
public class TenMinutesParser extends AbstractRestaurantParser {
    @Override
    public Object getMenu() throws IOException {
        byte[] picture = this.getDocumentAsByte();
        return picture;
    }

    @Override
    protected byte[] getDocumentAsByte() throws IOException {
        String responseUrl = getResponseUrl();
        Connection.Response resultImageResponse = Jsoup.connect(responseUrl).timeout(10 * 1000).ignoreContentType(true).execute();
        return resultImageResponse.bodyAsBytes();
    }

    @Override
    protected String getResponseUrl() throws IOException {
        return Restaurant.TENMINUTES.getUrl();
    }
}
