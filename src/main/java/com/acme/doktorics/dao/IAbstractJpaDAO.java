package com.acme.doktorics.dao;

import java.util.List;

public interface IAbstractJpaDAO<T> {


    void setClazz(final Class<T> clazzToSet);

    T findOne(final Long id);

    T findOne(final String id);

    T findOne();

    List<T> findAll();

    void save(final T entity);

    void update(final T entity);

    void delete(final T entity);

    void truncate();

}