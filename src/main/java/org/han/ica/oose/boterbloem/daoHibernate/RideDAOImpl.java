package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RideEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RideDAOImpl extends GenericDAOImpl<RideEntity> implements IRideDAO {

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
            int returnvalue =  ((Number) getEntityManager().createQuery("SELECT count(*) FROM RideEntity  WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).intValue();
            return returnvalue;

        } catch (NullPointerException n){
            return 0;
        }
    }

    @Override
    public int totalRideClient(int id) {
        return ((Number) getEntityManager().createQuery("SELECT count(*) FROM RideEntity  " +
                "WHERE clientEntity.clientId = :id").setParameter("id", id).getSingleResult()).intValue();
    }

    @Override
    public float totalEarned(int id) {
        try {
            float returnvalue =  ((Number) getEntityManager().createQuery("SELECT SUM(price_of_ride) FROM RideEntity WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).floatValue();
            return returnvalue;
        } catch (NullPointerException n){
            return 0;
        }
    }

}
