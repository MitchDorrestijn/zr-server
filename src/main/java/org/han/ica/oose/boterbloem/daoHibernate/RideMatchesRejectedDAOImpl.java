package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.RidematchesrejectedEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RideMatchesRejectedDAOImpl extends GenericDAOImpl<RidematchesrejectedEntity> implements IRideMatchesRejectedDAOm {

    @Autowired
    public RideMatchesRejectedDAOImpl(EntityManager em) {
        super(em, RidematchesrejectedEntity.class);
    }
}
