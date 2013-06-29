package com.acme.doktorics.service;

import com.acme.doktorics.domain.ClubCaffeRestaurant;
import com.acme.doktorics.domain.DailyMenu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public interface IClubCaffeService {

    List<ClubCaffeRestaurant> find();

    ClubCaffeRestaurant findOne();

    List<DailyMenu> getMenu();

    void deleteRestaurant(String id);

    void saveRestaurant(ClubCaffeRestaurant restaurant);

    void truncate();
}
