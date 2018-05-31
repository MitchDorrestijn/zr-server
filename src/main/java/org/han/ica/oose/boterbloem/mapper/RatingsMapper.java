package org.han.ica.oose.boterbloem.mapper;

import org.han.ica.oose.boterbloem.daoHibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.daoHibernate.IUserDAO;
import org.han.ica.oose.boterbloem.daoHibernate.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.UserDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainImplementation.Ratings;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;
import org.han.ica.oose.boterbloem.service.RatingsService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatingsMapper extends GenericMapper {
    private static final Logger LOGGER = Logger.getLogger(RatingsService.class.getName());

    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();

    /**
     * @param driverId the driverID where you wnat to get the specific ratings from
     * @return a list of ratings from a specific driver
     */
    public List<Ratings> getAllRatingsFromASpecificDriver(int driverId) {
        List<Ratings> ratings = new ArrayList<>();
        try {
            for(RatingsEntity r : ratingsDAO.getByDriver(driverId)){
                Ratings rating = new Ratings();
                rating.setClientName(findNameById(r.getClientId()));
                rating.setDriverName(findNameById(r.getDriverId()));
                rating.setStars(r.getSterren());
                rating.setComment(r.getBeoordeling());
                ratings.add(rating);
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return ratings;
    }

    /**
     * not implmented maybe for future use
     * @return
     */
    public List<Ratings> ratingByClient() {
        return new ArrayList<>();
    }

    /**
     * returns a list of all ratings
     * @return
     */
    public List<Ratings> allRatings() {
        List<Ratings> ratings = new ArrayList<>();
        try {
            for (RatingsEntity r : ratingsDAO.findAll()) {
                Ratings rating = new Ratings();
                rating.setClientName(findNameById(r.getClientId()));
                rating.setDriverName(findNameById(r.getDriverId()));
                rating.setStars(r.getSterren());
                rating.setComment(r.getBeoordeling());
                ratings.add(rating);
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return ratings;
    }
    
    public List<List<Ratings>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId){
        List<List<RatingsEntity>> ratingsentities = ratingsDAO.getByCareInstitution(careInstitutionId);
        List<List<Ratings>> ratings = new ArrayList<>();

        for (List<RatingsEntity> r: ratingsentities) {
            List<Ratings> re = new ArrayList<>();
            for (RatingsEntity ra: r) {
                Ratings adder = new Ratings();
                adder.setClientName(findNameById(ra.getClientId()));
                adder.setDriverName(findNameById(ra.getDriverId()));
                adder.setStars(ra.getSterren());
                adder.setComment(ra.getBeoordeling());
                re.add(adder);
            }
            ratings.add(re);
        }
            return  ratings;
        }
}
