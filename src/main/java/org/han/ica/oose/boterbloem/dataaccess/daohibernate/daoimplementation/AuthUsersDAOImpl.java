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
        try {
            return getEntityManager().find(AuthUsersEntity.class, userName);
        } catch (NullPointerException e){
            LOGGER.log(Level.WARNING, e.getMessage());
            return new AuthUsersEntity();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean findIfTokenExist(String token){
        try {
            return (getEntityManager().createQuery("FROM AuthUsersEntity " +
                    "WHERE latestToken = :latestToken").setParameter("latestToken", token).getSingleResult() != null);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return false;
    }

}