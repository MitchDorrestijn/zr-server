package org.han.ica.oose.boterbloem.daoHibernate.genericDao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

public abstract class GenericDAOImpl<T> implements IGenericDAO<T>{

    private Class<T> classImpl;

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager em = entityManagerFactory.createEntityManager();

    private static final Logger LOGGER = Logger.getLogger(GenericDAOImpl.class.getName());


    public GenericDAOImpl(Class<T> classImpl) {
        this.classImpl = classImpl;
    }

    @Override
    public T add(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        return entity;
    }

    @Override
    public T update(T entity) {
        em.getTransaction().begin();
        T mergedEntity = em.merge(entity);
        em.getTransaction().commit();
        return mergedEntity;
    }

    @Override
    public void remove(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public T findById(int id) {
        em.getTransaction().begin();
        T entity = (T) em.find(classImpl, id);
        em.getTransaction().commit();
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        em.getTransaction().begin();
        List<T> entities = em.createQuery("SELECT x FROM " + classImpl.getSimpleName() + " x").getResultList();
        em.getTransaction().commit();
        return entities;
    }

    @Override
    public void flush() {
        em.flush();
    }

    /**
     *
     * @return The implementation class of this DAO
     */
    public Class<T> getClassImpl(){
        return classImpl;
    }

    /**
     *
     * @return entitymanager used by this DAO
     */
    public EntityManager getEntityManager(){
        return em;
    }
}