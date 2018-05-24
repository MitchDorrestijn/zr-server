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
            //getEntityManager().getTransaction().begin();
            int returnvalue =  ((Number) getEntityManager().createQuery("SELECT count(*) FROM RideEntity  WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).intValue();
            //getEntityManager().getTransaction().commit();
            return returnvalue;

        } catch (NullPointerException n){
            return 0;
        }
    }

    @Override
    public float totalEarned(int id) {
        try {
            //getEntityManager().getTransaction().begin();
            float returnvalue =  ((Number) getEntityManager().createQuery("SELECT SUM(price_of_ride) FROM RideEntity WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).floatValue();
            //getEntityManager().getTransaction().commit();
            return returnvalue;
        } catch (NullPointerException n){
            return 0;
        }
    }

}
