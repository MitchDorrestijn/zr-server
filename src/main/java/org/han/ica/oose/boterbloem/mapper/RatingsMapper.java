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

public class RatingsMapper {
    private static final Logger LOGGER = Logger.getLogger(RatingsService.class.getName());

    private IUserDAO userDAO = new UserDAOImpl();
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();

    /**
     * @param driverId the driverID where you wnat to get the specific ratings from
     * @return a list of ratings from a specific driver
     */
    public List<Ratings> getAllRatingsFromASpecificDriver(int driverId) {
        List<Ratings> ratings = new ArrayList<>();
        for(RatingsEntity r : ratingsDAO.getByDriver(driverId)){
            Ratings rating = new Ratings();
            rating.setClientName(findNameByRating(r.getClientId()));
            rating.setDriverName(findNameByRating(r.getDriverId()));
            rating.setStars(r.getSterren());
            rating.setComment(r.getBeoordeling());
            ratings.add(rating);
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
        for (RatingsEntity r : ratingsDAO.findAll()) {
            Ratings rating = new Ratings();
            rating.setClientName(findNameByRating(r.getClientId()));
            rating.setDriverName(findNameByRating(r.getDriverId()));
            rating.setStars(r.getSterren());
            rating.setComment(r.getBeoordeling());
            ratings.add(rating);
        }
        return ratings;
    }

    /**
     * return name from user
     * @param id
     * @return
     */
    private String findNameByRating(int id) {
        return userDAO.findById(id).getFirstName() + " " + userDAO.findById(id).getLastName();
    }

}
