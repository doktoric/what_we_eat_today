package com.acme.doktorics.service;

import com.acme.doktorics.dao.IKompotDao;
import com.acme.doktorics.domain.KompotRestaurant;
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
public class KompotService implements IKompotService {

    @Autowired
    private IKompotDao kompotDao;

    @Override
    public List<KompotRestaurant> find() {
        List<KompotRestaurant> restaurants = kompotDao.findAll();
        return restaurants;
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
}
