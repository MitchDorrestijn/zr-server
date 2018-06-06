package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthUsersDAOImpl extends GenericDAOImpl<AuthUsersEntity> implements IAuthUsersDAO {

    /**
     * Hook up the basic CRUD queries
     */
    public AuthUsersDAOImpl() {
        super(AuthUsersEntity.class);
    }

}
