package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;


import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RideDAOImpl extends GenericDAOImpl<RideEntity> implements IRideDAO {

    private static final Logger LOGGER = Logger.getLogger(RideDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public RideDAOImpl() {
        super(RideEntity.class);
    }

    @Override
    public int rideCountById(int id) {
        try {
            return ((Number) getEntityManager().createQuery("SELECT count(*) FROM RideEntity  WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).intValue();
        } catch (Exception n) {
            LOGGER.log(Level.WARNING, n.getMessage());
            return 0;
        }
    }

    @Override
    public int totalRideClient(int id) {
        try {
            return ((Number) getEntityManager().createQuery("SELECT count(*) FROM RideEntity  " +
                    "WHERE clientEntity.clientId = :id").setParameter("id", id).getSingleResult()).intValue();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return 0;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RideEntity> getByClient(int id) {
        try {
            return getEntityManager().createQuery("FROM RideEntity " +
                    "WHERE clientEntity.clientId = :id").setParameter("id", id).getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RideEntity> getByDriver(int id) {
        try {
            String query = "FROM RideEntity WHERE driverEntity.driverId = :id";
            return getEntityManager().createQuery(query).setParameter("id", id).getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public float totalEarned(int id) {
        try {
            return ((Number) getEntityManager().createQuery("SELECT SUM(priceOfRide) FROM RideEntity WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).floatValue();
        } catch (NullPointerException n) {
            LOGGER.log(Level.WARNING, n.getMessage());
            return 0;
        }
    }

    /**
     * return rides from a careinstitution
     */
    @SuppressWarnings("unchecked")
    public List<RideEntity> ridesWithCareinstitution(int careId) {
        try {
            return getEntityManager().createQuery("FROM RideEntity s WHERE driverEntity.driverId IN (SELECT driverId FROM DrivercareinstitutionEntity WHERE careInstitutionId = :careId) OR clientEntity.clientId IN (SELECT clientId from ClientcareinstitutionEntity WHERE careInstitutionId = :careId) ").setParameter("careId", careId).getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public RideEntity getByClientAndDateTime(int clientId, Timestamp date) {
        try {
            return (RideEntity) getEntityManager().createQuery("FROM RideEntity WHERE clientEntity.clientId = :id AND pickUpDateTime = :date").setParameter("id", "%" + clientId + "%").setParameter("date", date).getSingleResult();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
            return new RideEntity();
        }
    }
}


