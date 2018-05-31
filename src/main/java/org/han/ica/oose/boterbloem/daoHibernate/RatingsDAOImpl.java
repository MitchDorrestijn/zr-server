package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainImplementation.Ratings;
import org.han.ica.oose.boterbloem.entity.DrivercareinstitutionEntity;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;
import org.han.ica.oose.boterbloem.entity.RatingsPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatingsDAOImpl extends GenericDAOImpl<RatingsEntity> implements IRatingsDAO {

    private static final Logger LOGGER = Logger.getLogger(RatingsDAOImpl.class.getName());

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

    /**
     * @param careInstitutionId the id of the careInstitution
     * @return a list of ratings of the drivers from a specific careInstitution
     */
    @Override
    public List<List<RatingsEntity>> getByCareInstitution(int careInstitutionId) {
        List<RatingsEntity> ratingsEntities = new ArrayList<>();
        List<List<RatingsEntity>> testlijst = new ArrayList<>();
        try {
            List<DrivercareinstitutionEntity> drivercareinstitutionEntities = getEntityManager().createQuery("FROM DrivercareinstitutionEntity " +
                    "WHERE careInstitutionId = :careInstitutionId").setParameter("careInstitutionId", careInstitutionId).getResultList();

            for (DrivercareinstitutionEntity d: drivercareinstitutionEntities) {
                testlijst.add(getByDriver(d.getDriverId()));
            }


//            for(int i=0; i< drivercareinstitutionEntities.size(); i++){
//                    System.out.println("HIER KOMT IE");
//                    ratingsEntities.add(findById(drivercareinstitutionEntities.get(i).getCareInstitutionId()));
//            }
        } catch (NullPointerException e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        //return ratingsEntities;
        for (int i = 0; i <testlijst.size() ; i++) {
            System.out.println("AAA " + testlijst.get(i));
        }
        return testlijst;
    }



}
