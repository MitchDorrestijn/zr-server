package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RatingsDAOImpl extends GenericDAOImpl<RatingsEntity> implements IRatingsDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public RatingsDAOImpl(EntityManager em) {
        super(em, RatingsEntity.class);
    }

    public int getAvgRatings(int id){
        try {
            return ((Number) getEntityManager().createQuery("SELECT AVG(sterren) FROM RatingsEntity WHERE driverId = :id").setParameter("id", id).getSingleResult()).intValue();
        } catch (NullPointerException n){
            return 0;
        }
    }
}
