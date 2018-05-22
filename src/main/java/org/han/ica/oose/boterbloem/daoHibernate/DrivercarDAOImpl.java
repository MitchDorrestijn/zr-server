package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DrivercarDAOImpl extends GenericDAOImpl<DrivercarEntity> implements IDrivercarDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public DrivercarDAOImpl(EntityManager em) {
        super(em, DrivercarEntity.class);
    }

    public DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK){
        return getEntityManager().find(DrivercarEntity.class, drivercarEntityPK);
    }
}
