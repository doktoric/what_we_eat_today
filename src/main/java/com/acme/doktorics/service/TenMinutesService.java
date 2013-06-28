package com.acme.doktorics.service;

import com.acme.doktorics.dao.ITenMinutesDao;
import com.acme.doktorics.domain.TenMinutesRestaurant;
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
public class TenMinutesService implements ITenMinutesService {

    @Autowired
    private ITenMinutesDao tenMinutesDao;

    @Override
    public List<TenMinutesRestaurant> find() {
        List<TenMinutesRestaurant> restaurants = tenMinutesDao.findAll();
        return restaurants;
    }

    @Override
    public TenMinutesRestaurant findOne() {
        return tenMinutesDao.findOne();
    }

    @Override
    public void truncate() {
        tenMinutesDao.truncate();
    }

    @Override
    public void deleteRestaurant(String id) {
        TenMinutesRestaurant restaurant = tenMinutesDao.findOne(id);
        tenMinutesDao.delete(restaurant);
    }

    @Override
    public void saveRestaurant(TenMinutesRestaurant restaurant) {
        tenMinutesDao.save(restaurant);
    }
}
