package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements IUserDAO {

    /**
     * Hook up the basic CRUD queries
     */
    public UserDAOImpl() {
        super(UserEntity.class);
    }

    public String driverNameById(int id) {
        return ((String) getEntityManager().createQuery("SELECT firstName FROM UserEntity WHERE id = :id").setParameter("id", id).getSingleResult());
    }

}
