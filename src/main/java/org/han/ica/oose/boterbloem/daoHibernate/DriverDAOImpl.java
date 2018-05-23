package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriverDAOImpl extends GenericDAOImpl<DriverEntity> implements IDriverDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public DriverDAOImpl(EntityManager em) {
        super(em, DriverEntity.class);
    }


    public int latestId(){
        return ((Number) getEntityManager().createQuery("SELECT MAX(driverId) FROM DriverEntity").getSingleResult()).intValue();
    }
}

