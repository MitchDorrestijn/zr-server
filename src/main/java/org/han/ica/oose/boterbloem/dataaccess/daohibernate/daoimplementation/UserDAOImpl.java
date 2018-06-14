package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;


import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUserDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UserEntity;

import java.util.logging.Level;

public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements IUserDAO {

    /**
     * Hook up the basic CRUD queries
     */
    public UserDAOImpl() {
        super(UserEntity.class);
    }

    public String driverNameById(int id) {
        try {
            return ((String) getEntityManager().createQuery("SELECT firstName FROM UserEntity WHERE id = :id").setParameter("id", id).getSingleResult());
        }catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
            return "";
        }
    }

}
