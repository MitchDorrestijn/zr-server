package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.DriveravailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriveravailabilityDAOImpl extends GenericDAOImpl<DriveravailabilityEntity> implements IDriveravailabilityDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DriveravailabilityDAOImpl() {
        super(DriveravailabilityEntity.class);
    }
}
