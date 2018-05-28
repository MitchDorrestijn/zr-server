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
        getEntityManager().getTransaction().begin();
        int returnvalue = ((Number) getEntityManager().createQuery("SELECT MAX(driverId) FROM DriverEntity").getSingleResult()).intValue();
        getEntityManager().getTransaction().commit();
        return returnvalue;
    }

    @Override
    public void deleteDriver(int driverId) {
        getEntityManager().getTransaction().begin();
        getEntityManager().createQuery("UPDATE DrivercareinstitutionEntity SET DrivercareinstitutionEntity.active = false " +
                    "WHERE DrivercareinstitutionEntity.driverId = :driverId").setParameter("driverId", driverId).getResultList();
        getEntityManager().getTransaction().commit();
    }
}

