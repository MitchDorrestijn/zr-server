package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriveravailabilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriveravailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class DriveravailabilityDAOImpl extends GenericDAOImpl<DriveravailabilityEntity> implements IDriveravailabilityDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DriveravailabilityDAOImpl() {
        super(DriveravailabilityEntity.class);
    }
}
