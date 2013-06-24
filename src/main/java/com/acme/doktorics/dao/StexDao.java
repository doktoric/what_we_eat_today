package com.acme.doktorics.dao;

import com.acme.doktorics.domain.StexRestaurant;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.23.
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class StexDao extends AbstractJpaDAO<StexRestaurant> implements IStexDao{
    public StexDao() {
        setClazz(StexRestaurant.class);
    }
}
