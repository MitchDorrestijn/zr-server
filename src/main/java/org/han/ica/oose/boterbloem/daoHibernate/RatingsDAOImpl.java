package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class RatingsDAOImpl extends GenericDAOImpl<RatingsEntity> implements IRatingsDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public RatingsDAOImpl() {
        super(RatingsEntity.class);
    }

    public int getAvgRatings(int id){
        try {
            int returnValue = ((Number) getEntityManager().createQuery("SELECT AVG(sterren) FROM RatingsEntity WHERE driverEntity.driverId = :id").setParameter("id", id).getSingleResult()).intValue();
            return returnValue;
        } catch (NullPointerException n){
            return 0;
        }
    }

    @Override
    public List<RatingsEntity> getByDriver(int driverId) {
        return getEntityManager().createQuery("FROM RatingsEntity " +
                "WHERE driverId = :driverId").setParameter("driverId", driverId).getResultList();
    }

}
