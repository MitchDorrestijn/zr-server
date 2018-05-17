package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.RideEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RideDAOImpl extends GenericDAOImpl<RideEntity> implements IRideDAOm {

    @Autowired
    public RideDAOImpl(EntityManager em) {
        super(em, RideEntity.class);
    }
}
