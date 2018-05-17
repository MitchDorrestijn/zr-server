package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.DriveravailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriverAvailabilityDAOImpl extends GenericDAOImpl<DriveravailabilityEntity> implements IDriverAvailabilityDAOm {

    @Autowired
    public DriverAvailabilityDAOImpl(EntityManager em) {
        super(em, DriveravailabilityEntity.class);
    }
}
