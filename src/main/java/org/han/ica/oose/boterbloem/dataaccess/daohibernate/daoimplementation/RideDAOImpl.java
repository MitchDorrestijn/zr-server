package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class RideDAOImpl extends GenericDAOImpl <RideEntity> implements IRideDAO {

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
            int returnvalue = ((Number) getEntityManager().createQuery("SELECT count(*) FROM RideEntity  WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).intValue();
            return returnvalue;

        } catch ( NullPointerException n ) {
            return 0;
        }
    }

    @Override
    public int totalRideClient(int id) {
        return ((Number) getEntityManager().createQuery("SELECT count(*) FROM RideEntity  " +
                "WHERE clientEntity.clientId = :id").setParameter("id", id).getSingleResult()).intValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RideEntity> getByClient(int id) {
        return getEntityManager().createQuery("FROM RideEntity " +
                "WHERE clientEntity.clientId = :id").setParameter("id", id).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List <RideEntity> getByDriver(int id) {
        String query = "FROM RideEntity WHERE driverEntity.driverId = :id";
        return getEntityManager().createQuery(query).setParameter("id", id).getResultList();
    }

    @Override
    public float totalEarned(int id) {
        try {
            return ((Number) getEntityManager().createQuery("SELECT SUM(priceOfRide) FROM RideEntity WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).floatValue();
        } catch ( NullPointerException n ) {
            return 0;
        }
    }

}
