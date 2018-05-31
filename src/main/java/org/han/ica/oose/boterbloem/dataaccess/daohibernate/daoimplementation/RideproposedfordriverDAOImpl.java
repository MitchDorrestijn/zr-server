package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideproposedfordriverDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideproposedfordriverEntity;

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
