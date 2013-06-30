package com.acme.doktorics.service;

import com.acme.doktorics.dao.IKompotDao;
import com.acme.doktorics.domain.ClubCaffeRestaurant;
import com.acme.doktorics.domain.DailyMenu;
import com.acme.doktorics.domain.KompotRestaurant;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class KompotService implements IKompotService {

    @Autowired
    private IKompotDao kompotDao;

    @Override
    public List<KompotRestaurant> find() {
        List<KompotRestaurant> restaurants = kompotDao.findAll();
        return restaurants;
    }

    @Override
    public KompotRestaurant findOne() {
        return kompotDao.findOne();
    }

    @Override
    public List<DailyMenu> getMenu() {
        KompotRestaurant kompot = findOne();
        if (kompot != null) {
            Hibernate.initialize(kompot.getMenu());
            return kompot.getMenu();
        }
        return new ArrayList<DailyMenu>();
    }

    @Override
    public void saveNewMenu(DailyMenu menu) {
        KompotRestaurant kompotRestaurant = findOne();
        if (kompotRestaurant != null) {
            Hibernate.initialize(kompotRestaurant.getMenu());
        }
        for(int i=0;i<kompotRestaurant.getMenu().size();i++){
            if(menu.getDay().equals(kompotRestaurant.getMenu().get(i).getDay())){
                kompotRestaurant.getMenu().remove(i);
                i--;
                break;
            }
        }
        kompotRestaurant.addMenu(menu);
        saveRestaurant(kompotRestaurant);
    }

    @Override
    public void deleteRestaurant(String id) {
        KompotRestaurant restaurant = kompotDao.findOne(id);
        kompotDao.delete(restaurant);
    }

    @Override
    public void saveRestaurant(KompotRestaurant restaurant) {
        kompotDao.save(restaurant);
    }

    @Override
    public void truncate() {
        kompotDao.truncate();
    }
}
