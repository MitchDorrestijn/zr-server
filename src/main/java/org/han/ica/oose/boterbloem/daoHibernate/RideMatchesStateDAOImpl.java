package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.RidematchesstateEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RideMatchesStateDAOImpl extends GenericDAOImpl<RidematchesstateEntity> implements IRideMatchesStateDAOm {

    @Autowired
    public RideMatchesStateDAOImpl(EntityManager em) {
        super(em, RidematchesstateEntity.class);
    }
}
