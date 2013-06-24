package com.acme.doktorics.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AbstractJpaDAO<T> implements IAbstractJpaDAO<T> {
    private Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
}

    @Override
    public T findOne(final Long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        List<T> result = entityManager.createQuery("from " + clazz.getName())
                .getResultList();
        return result;

    }

    @Override
    public T findOne(String id) {
        return findOne( Long.parseLong(id));
    }

    @Override
    public void save(final T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(final T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(final T entity) {
        entityManager.remove(entity);
    }

}
