package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IRideproposedfordriverDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.RideproposedfordriverEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class RideproposedfordriverDAOImpl extends GenericDAOImpl<RideproposedfordriverEntity> implements IRideproposedfordriverDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public RideproposedfordriverDAOImpl() {
        super(RideproposedfordriverEntity.class);
    }
}
