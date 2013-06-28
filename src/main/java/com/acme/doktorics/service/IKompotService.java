package com.acme.doktorics.service;

import com.acme.doktorics.domain.ClubCaffeRestaurant;
import com.acme.doktorics.domain.KompotRestaurant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public interface IKompotService {

    List<KompotRestaurant> find();

    KompotRestaurant findOne();

    void deleteRestaurant(String id);

    void saveRestaurant(KompotRestaurant restaurant);

    void truncate();
}
