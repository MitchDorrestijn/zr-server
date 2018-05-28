package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RidematchesstateEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RidematchesstateDAOImpl extends GenericDAOImpl<RidematchesstateEntity> implements IRidematchesstateDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public RidematchesstateDAOImpl() {
        super(RidematchesstateEntity.class);
    }
}
