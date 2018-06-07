package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDrivercarDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntityPK;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DrivercarDAOImpl extends GenericDAOImpl<DrivercarEntity> implements IDrivercarDAO {
    private static final Logger LOGGER = Logger.getLogger(DrivercarDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */

    public DrivercarDAOImpl() {
        super(DrivercarEntity.class);
    }

    public DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK) {
        try {
            return getEntityManager().find(DrivercarEntity.class, drivercarEntityPK);
        } catch (NullPointerException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new DrivercarEntity();
        }
    }


    @SuppressWarnings("unchecked")
    public DrivercarEntity findCarById(int driverId) {

        try {
            String utility;
            utility = getUtility(driverId);
            if (utility.equals("")) {
                return new DrivercarEntity();
            }
            DrivercarEntityPK drivercarEntityPK = new DrivercarEntityPK();
            drivercarEntityPK.setDriverId(driverId);
            drivercarEntityPK.setUtility(utility);
            return findByPK(drivercarEntityPK);

        } catch (NullPointerException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new DrivercarEntity();
        }
    }

    private String getUtility(int driverId) {
        try {
            return (String) getEntityManager().createQuery("SELECT utility FROM DrivercarEntity dr WHERE dr.driverId = :driverId").setParameter("driverId", driverId).getSingleResult();
        } catch (NoResultException e) {
            return "";
        }
    }

    /**
     * @param driverId id of a driver
     * @return List of driverCars
     */
    @SuppressWarnings("unchecked")
    public List<DrivercarEntity> drivercarEntityListByDriverId(int driverId) {
        try {
            return getEntityManager().createQuery("FROM DrivercarEntity WHERE driverId = :driverId").setParameter("driverId", driverId).getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new ArrayList<>();
        }
    }

}
