package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;


import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.springframework.beans.factory.annotation.Autowired;

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
}

