package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RidematchescacheEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RidematchescacheDAOImpl extends GenericDAOImpl<RidematchescacheEntity> implements IRidematchescacheDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public RidematchescacheDAOImpl() {
        super(RidematchescacheEntity.class);
    }
}
