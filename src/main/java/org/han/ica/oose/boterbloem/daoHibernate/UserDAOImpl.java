package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements IUserDAO {

    @Autowired
    public UserDAOImpl(EntityManager em) {
        super(em, UserEntity.class);
    }
}
