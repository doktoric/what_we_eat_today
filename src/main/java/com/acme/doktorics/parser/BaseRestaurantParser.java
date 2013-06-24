package com.acme.doktorics.parser;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public interface BaseRestaurantParser {
    Object getMenu() throws IOException;
}
