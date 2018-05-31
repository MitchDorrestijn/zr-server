package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverDAOImpl extends GenericDAOImpl<DriverEntity> implements IDriverDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DriverDAOImpl() {
        super(DriverEntity.class);
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

