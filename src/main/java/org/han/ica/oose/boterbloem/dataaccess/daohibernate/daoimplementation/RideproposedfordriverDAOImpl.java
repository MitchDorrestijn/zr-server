package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class RideproposedfordriverDAOImpl extends GenericDAOImpl<RideproposedfordriverEntity> implements IRideproposedfordriverDAO {

    /**
     * Hook up the basic CRUD queries
     *
     * @param em [provided] - runs querys
     */

    public RideproposedfordriverDAOImpl() {
        super(RideproposedfordriverEntity.class);
    }
}
