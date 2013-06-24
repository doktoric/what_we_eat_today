package com.acme.doktorics.dao;

import com.acme.doktorics.domain.FiktivRestaurant;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
//@Repository
public class FiktivDao extends AbstractJpaDAO<FiktivRestaurant> implements IFiktivDao{
    public FiktivDao() {
        setClazz(FiktivRestaurant.class);
    }
}
