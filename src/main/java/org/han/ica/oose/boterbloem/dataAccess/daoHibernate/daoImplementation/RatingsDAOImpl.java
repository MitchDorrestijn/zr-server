package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.RatingsEntity;
import org.springframework.beans.factory.annotation.Autowired;

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
            int returnValue = ((Number) getEntityManager().createQuery("SELECT AVG(sterren) FROM RatingsEntity WHERE driverId = :id").setParameter("id", id).getSingleResult()).intValue();
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
