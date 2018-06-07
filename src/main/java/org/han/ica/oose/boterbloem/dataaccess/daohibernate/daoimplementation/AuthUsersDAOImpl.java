package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;

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
        return (AuthUsersEntity) getEntityManager().createQuery("FROM AuthUsersEntity "+
                "WHERE userName = :userName").setParameter("userName", userName).getSingleResult();
    }
}