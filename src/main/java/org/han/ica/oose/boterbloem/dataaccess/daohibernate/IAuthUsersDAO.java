package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;

public interface IAuthUsersDAO extends IGenericDAO<AuthUsersEntity> {

    /**
     * Find auhenticated user by a given name
     * @param userName
     * @return
     */
    AuthUsersEntity findByUserName(String userName);
}
