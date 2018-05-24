package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.LimitationEntity;
import org.han.ica.oose.boterbloem.entity.RidematchescacheEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class LimitationDAOImpl extends GenericDAOImpl<LimitationEntity> implements ILimitationDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public LimitationDAOImpl(EntityManager em) {
        super(em, LimitationEntity.class);
    }
}
