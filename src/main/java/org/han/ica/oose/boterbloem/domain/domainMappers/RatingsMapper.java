package org.han.ica.oose.boterbloem.domain.domainMappers;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainObjects.Ratings;
import org.han.ica.oose.boterbloem.dataAccess.entities.RatingsEntity;
import org.han.ica.oose.boterbloem.service.serviceImplementation.RatingsService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatingsMapper extends GenericMapper {
    private static final Logger LOGGER = Logger.getLogger(RatingsService.class.getName());

    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();

    /**
     * returns a list of all ratings
     * @return
     */
    public List<Ratings> getAllRatings() {
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

    /**
     * @param driverId the driverID where you wnat to get the specific ratings from
     * @return a list of ratings from a specific driver
     */
    public List<Ratings> getAllRatingsFromASpecificDriverById(int driverId) {
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


}
