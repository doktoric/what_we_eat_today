package com.acme.doktorics.domain;

import com.acme.doktorics.parser.AbstractRestaurantParser;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.30.
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 */
public class DailyMenuComparator implements Comparator<DailyMenu>
{
    @Override
    public int compare(DailyMenu c1, DailyMenu c2)
    {
        Integer c1Order=java.util.Arrays.asList(AbstractRestaurantParser.DAYS).indexOf(c1.getDay());
        if(c1.getDay().equals("Hétf?")){
            c1Order=0;
        }
        Integer c2Order=java.util.Arrays.asList(AbstractRestaurantParser.DAYS).indexOf(c2.getDay());
        if(c2.getDay().equals("Hétf?")){
            c2Order=0;
        }
        return c1Order.compareTo(c2Order);
    }
}