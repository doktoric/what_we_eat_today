package com.acme.doktorics.service;

import com.acme.doktorics.dao.IClubCaffeDao;
import com.acme.doktorics.domain.ClubCaffeRestaurant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
//@Service
//@Transactional
public class ClubCaffeService implements IClubCaffeService {

    @Autowired
    private IClubCaffeDao clubCaffeDao;

    @Override
    public List<ClubCaffeRestaurant> find() {
        List<ClubCaffeRestaurant> restaurants = clubCaffeDao.findAll();
        return restaurants;
    }

    @Override
    public void deleteRestaurant(String id) {
        ClubCaffeRestaurant restaurant = clubCaffeDao.findOne(id);
        clubCaffeDao.delete(restaurant);
    }

    @Override
    public void saveRestaurant(ClubCaffeRestaurant restaurant) {
        clubCaffeDao.save(restaurant);
    }
}
