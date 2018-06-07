package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;

import javax.persistence.EntityManager;
import java.util.logging.Level;

public class AuthUsersDAOImpl extends GenericDAOImpl<AuthUsersEntity> implements IAuthUsersDAO {

    /**
     * Hook up the basic CRUD queries
     */
    public AuthUsersDAOImpl() {
        super(AuthUsersEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthUsersEntity findByUserName(String userName) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            return (AuthUsersEntity) em.createQuery("FROM AuthUsersEntity " +
                    "WHERE userName = :userName").setParameter("userName", userName).getSingleResult();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } finally {
            em.close();
        }
        return null;
    }

}