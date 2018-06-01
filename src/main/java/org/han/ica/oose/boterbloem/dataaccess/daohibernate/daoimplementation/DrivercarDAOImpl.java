package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

import javax.persistence.NoResultException;
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
        } catch (Exception e) {
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

        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new DrivercarEntity();
        }
    }

    private String getUtility(int driverId) {
        try {
            return (String) this.getEntityManager().createQuery("SELECT utility FROM DrivercarEntity dr WHERE dr.driverId = :driverId").setParameter("driverId", driverId).getSingleResult();
        } catch (NoResultException e) {
            return "";
        }
    }

}
