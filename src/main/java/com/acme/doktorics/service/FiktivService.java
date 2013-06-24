package com.acme.doktorics.service;

import com.acme.doktorics.dao.IFiktivDao;
import com.acme.doktorics.domain.FiktivRestaurant;
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
public class FiktivService implements IFiktivService {

    @Autowired
    private IFiktivDao fiktivDao;

    @Override
    public List<FiktivRestaurant> find() {
        List<FiktivRestaurant> restaurants = fiktivDao.findAll();
        return restaurants;
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
