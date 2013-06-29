package com.acme.doktorics.service;

import com.acme.doktorics.domain.TenMinutesRestaurant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public interface ITenMinutesService {

    List<TenMinutesRestaurant> find();

    TenMinutesRestaurant findOne();

    String getMenu();

    void deleteRestaurant(String id);

    void saveRestaurant(TenMinutesRestaurant restaurant);

    void truncate();
}
