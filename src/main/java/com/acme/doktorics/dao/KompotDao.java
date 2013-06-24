package com.acme.doktorics.dao;

import com.acme.doktorics.domain.KompotRestaurant;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
//@Repository
public class KompotDao extends AbstractJpaDAO<KompotRestaurant> implements IKompotDao {
    public KompotDao() {
        setClazz(KompotRestaurant.class);
    }
}
