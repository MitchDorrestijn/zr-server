package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RideproposedfordriverEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RideproposedfordriverDAOImpl extends GenericDAOImpl<RideproposedfordriverEntity> implements IRideproposedfordriverDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public RideproposedfordriverDAOImpl(EntityManager em) {
        super(em, RideproposedfordriverEntity.class);
    }
}
