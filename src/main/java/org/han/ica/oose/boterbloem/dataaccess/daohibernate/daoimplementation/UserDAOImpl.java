package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUserDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements IUserDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public UserDAOImpl() {
        super(UserEntity.class);
    }

    public String driverNameById(int id){
        return ((String) getEntityManager().createQuery("SELECT firstName FROM UserEntity WHERE id = :id").setParameter("id", id).getSingleResult());
    }

}