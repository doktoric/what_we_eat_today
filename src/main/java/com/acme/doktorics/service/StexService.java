package com.acme.doktorics.service;

import com.acme.doktorics.dao.IStexDao;
import com.acme.doktorics.domain.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class StexService implements IStexService {

    @Autowired
    private IStexDao stexDao;

    @Override
    public List<StexRestaurant> find() {
        List<StexRestaurant> restaurants = stexDao.findAll();
        return restaurants;
    }

    @Override
    public StexRestaurant findOne() {
        return stexDao.findOne();
    }

    @Override
    public List<DailyMenu> getMenu() {
        StexRestaurant stex = findOne();
        if (stex != null) {
            Hibernate.initialize(stex.getMenu());
            Collections.sort(stex.getMenu(), new DailyMenuComparator());
            return stex.getMenu();
        }
        return new ArrayList<DailyMenu>();
    }

    @Override
    public void saveNewMenu(DailyMenu menu) {
        StexRestaurant restaurant = findOne();
        if (restaurant != null) {
            Hibernate.initialize(restaurant.getMenu());
        }   else{
            restaurant=new StexRestaurant();
        }
        for(int i=0;i<restaurant.getMenu().size();i++){
            if(menu.getDay().equals(restaurant.getMenu().get(i).getDay())){
                restaurant.getMenu().remove(i);
                i--;
                break;
            }else if (menu.getDay().equals("Hétf?")) {
                Collections.sort(restaurant.getMenu(), new DailyMenuComparator());
                restaurant.getMenu().remove(i);
                i--;
                break;
            }
        }
        restaurant.addMenu(menu);
        saveRestaurant(restaurant);
    }

    @Override
    public void truncate() {
        stexDao.truncate();
    }

    @Override
    public void deleteRestaurant(String id) {
        StexRestaurant restaurant = stexDao.findOne(id);
        stexDao.delete(restaurant);
    }

    @Override
    public void saveRestaurant(StexRestaurant restaurant) {
        stexDao.save(restaurant);
    }
}
