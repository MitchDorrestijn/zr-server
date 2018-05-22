package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RideEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RideDAOImpl extends GenericDAOImpl<RideEntity> implements IRideDAO {

    /**
     * Hook up the basic CRUD queries
     *
     * @param em [provided] - runs querys
     */
    @Autowired
    public RideDAOImpl(EntityManager em) {
        super(em, RideEntity.class);
    }

    @Override
    public int rideCountById(int id) {
        try {
            return ((Number) getEntityManager().createQuery("SELECT count(*) FROM RideEntity  WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).intValue();
        } catch (NullPointerException n){
            return 0;
        }
    }

    @Override
    public float totalEarned(int id) {
        try {
            return  ((Number) getEntityManager().createQuery("SELECT SUM(price_of_ride) FROM RideEntity WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).floatValue();
        } catch (NullPointerException n){
            return 0;
        }
    }

}
