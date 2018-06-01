package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class DriveravailabilityDAOImpl extends GenericDAOImpl<DriveravailabilityEntity> implements IDriveravailabilityDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public DriveravailabilityDAOImpl() {
        super(DriveravailabilityEntity.class);
    }
}
