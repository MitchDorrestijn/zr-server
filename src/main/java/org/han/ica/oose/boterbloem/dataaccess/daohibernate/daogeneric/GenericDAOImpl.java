package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric;


import org.han.ica.oose.boterbloem.controller.LimitationController;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericDAOImpl<T> implements IGenericDAO<T> {
    private static final Logger LOGGER = Logger.getLogger(LimitationController.class.getName());
    private Class<T> classImpl;

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager em;

    public GenericDAOImpl(Class<T> classImpl) {
        em = entityManagerFactory.createEntityManager();
        this.classImpl = classImpl;
    }

    @Override
    public T add(T entity) {
        em.getTransaction().begin();
        try {
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return null;
    }

    @Override
    public T update(T entity) {
        em.getTransaction().begin();
        try {
            T mergedEntity = em.merge(entity);
            em.getTransaction().commit();
            return mergedEntity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return null;
    }

    @Override
    public void remove(T entity) {
        em.getTransaction().begin();
        try {
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public T findById(int id) {
        em.getTransaction().begin();
        try {
            T entity = em.find(classImpl, id);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        em.getTransaction().begin();
        try {
            List<T> entities = em.createQuery("SELECT x FROM " + classImpl.getSimpleName() + " x").getResultList();
            em.getTransaction().commit();
            return entities;
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void flush() {
        em.flush();
    }

    /**
     * @return The implementation class of this DAO
     */
    public Class<T> getClassImpl() {
        return classImpl;
    }

    /**
     * @return entitymanager used by this DAO
     */
    public EntityManager getEntityManager() {
        return em;
    }
}