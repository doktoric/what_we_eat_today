package com.acme.doktorics.service;

import com.acme.doktorics.dao.IStexDao;
import com.acme.doktorics.domain.StexRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
