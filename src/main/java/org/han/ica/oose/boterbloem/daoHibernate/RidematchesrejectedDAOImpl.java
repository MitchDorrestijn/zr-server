package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RidematchesrejectedEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RidematchesrejectedDAOImpl extends GenericDAOImpl<RidematchesrejectedEntity> implements IRidematchesrejectedDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public RidematchesrejectedDAOImpl() {
        super(RidematchesrejectedEntity.class);
    }
}