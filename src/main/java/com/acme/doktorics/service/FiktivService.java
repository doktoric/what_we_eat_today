package com.acme.doktorics.service;

import com.acme.doktorics.dao.IFiktivDao;
import com.acme.doktorics.domain.ClubCaffeRestaurant;
import com.acme.doktorics.domain.DailyMenu;
import com.acme.doktorics.domain.DailyMenuComparator;
import com.acme.doktorics.domain.FiktivRestaurant;
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
public class FiktivService implements IFiktivService {

    @Autowired
    private IFiktivDao fiktivDao;

    @Override
    public List<FiktivRestaurant> find() {
        List<FiktivRestaurant> restaurants = fiktivDao.findAll();
        return restaurants;
    }

    @Override
    public FiktivRestaurant findOne() {
        return fiktivDao.findOne();
    }

    @Override
    public List<DailyMenu> getMenu() {
        FiktivRestaurant fiktiv = findOne();
        if (fiktiv != null) {
            Hibernate.initialize(fiktiv.getMenu());
            Collections.sort(fiktiv.getMenu(), new DailyMenuComparator());
            return fiktiv.getMenu();
        }
        return new ArrayList<DailyMenu>();
    }

    @Override
    public void saveNewMenu(DailyMenu menu) {
        FiktivRestaurant restaurant = findOne();
        if (restaurant != null) {
            Hibernate.initialize(restaurant.getMenu());
        }   else{
            restaurant=new FiktivRestaurant();
        }
        for (int i = 0; i < restaurant.getMenu().size(); i++) {
            if (menu.getDay().equals(restaurant.getMenu().get(i).getDay())) {
                restaurant.getMenu().remove(i);
                i--;
                break;
            } else if (menu.getDay().equals("Hétf?")) {
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
        fiktivDao.truncate();
    }

    @Override
    public void deleteRestaurant(String id) {
        FiktivRestaurant restaurant = fiktivDao.findOne(id);
        fiktivDao.delete(restaurant);
    }

    @Override
    public void saveRestaurant(FiktivRestaurant restaurant) {
        fiktivDao.save(restaurant);
    }
}
