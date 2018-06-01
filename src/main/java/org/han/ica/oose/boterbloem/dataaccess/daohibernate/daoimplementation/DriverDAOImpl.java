package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.logging.*;

public class DriverDAOImpl extends GenericDAOImpl<DriverEntity> implements IDriverDAO {

    private static final Logger LOGGER = Logger.getLogger(DriverDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DriverDAOImpl() {
        super(DriverEntity.class);
    }

    public int latestId(){
        return ((Number) getEntityManager().createQuery("SELECT MAX(driverId) FROM DriverEntity").getSingleResult()).intValue();
    }

    @Override
    public void deleteDriver(int driverId) {
        getEntityManager().createQuery("UPDATE DrivercareinstitutionEntity SET DrivercareinstitutionEntity.active = false " +
                "WHERE DrivercareinstitutionEntity.driverId = :driverId").setParameter("driverId", driverId).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<DriverEntity> getByCareInstitutionId(int id) {
        List<DriverEntity> driverEntities = new ArrayList<>();
        try {
            List<DrivercareinstitutionEntity> drivercareinstitutionEntities = getEntityManager().createQuery("FROM DrivercareinstitutionEntity " +
                    "WHERE careInstitutionId = :id").setParameter("id", id).getResultList();

            for (DrivercareinstitutionEntity dr : drivercareinstitutionEntities) {
                driverEntities.add(findById(dr.getDriverId()));
            }
        } catch (NullPointerException e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return driverEntities;
    }
}

