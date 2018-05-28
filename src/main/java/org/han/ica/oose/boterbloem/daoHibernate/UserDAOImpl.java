package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements IUserDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public UserDAOImpl(EntityManager em) {
        super(em, UserEntity.class);
    }

    public String driverNameById(int id){
        //getEntityManager().getTransaction().begin();
        String name = ((String) getEntityManager().createQuery("SELECT firstName FROM UserEntity WHERE id = :id").setParameter("id", id).getSingleResult()).toString();
        //getEntityManager().getTransaction().commit();
        return name;

    }

}
