package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric;

import javax.persistence.EntityManager;
import java.util.List;

public interface IGenericDAO<T> {
    /**
     * Add entity to database
     *
     * @param entity the entity to add
     * @return the entity added
     */
    T add(T entity);

    /**
     * Update entity in database
     *
     * @param entity the entity to update
     * @return the entity updated
     */
    T update(T entity);

    /**
     * Delete entity from database
     *
     * @param entity the entity to delete
     */
    void remove(T entity);

    /**
     * Find all entities in database
     *
     * @return List of entities
     */
    List<T> findAll();

    /**
     * @param id the Id of the entity
     * @return entity found by id
     */
    T findById(int id);

    /**
     * flushes the entitymanager
     */
    void flush();

    void setEntityManager(EntityManager em);

}