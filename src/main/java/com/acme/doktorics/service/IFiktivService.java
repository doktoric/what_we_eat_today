package com.acme.doktorics.service;

import com.acme.doktorics.domain.ClubCaffeRestaurant;
import com.acme.doktorics.domain.DailyMenu;
import com.acme.doktorics.domain.FiktivRestaurant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public interface IFiktivService {

    List<FiktivRestaurant> find();

    FiktivRestaurant findOne();

    List<DailyMenu> getMenu();

    void deleteRestaurant(String id);

    public void saveNewMenu(DailyMenu menu);

    void saveRestaurant(FiktivRestaurant restaurant);

    void truncate();
}
