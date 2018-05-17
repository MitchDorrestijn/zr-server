package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.DriveravailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriveravailabilityDAOImpl extends GenericDAOImpl<DriveravailabilityEntity> implements IDriveravailabilityDAO {

    @Autowired
    public DriveravailabilityDAOImpl(EntityManager em) {
        super(em, DriveravailabilityEntity.class);
    }
}
