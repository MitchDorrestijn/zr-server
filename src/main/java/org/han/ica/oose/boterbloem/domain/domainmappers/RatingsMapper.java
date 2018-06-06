package org.han.ica.oose.boterbloem.domain.domainmappers;


import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RatingsEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatingsMapper {
    private static final Logger LOGGER = Logger.getLogger(RatingsMapper.class.getName());

    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();

    /**
     * @param driverId the driverID where you wnat to get the specific ratings from
     * @return a list of ratings from a specific driver
     */
    public List<Rating> getAllRatingsFromASpecificDriver(int driverId) {
        List<Rating> ratings = new ArrayList<>();
        try {
            for (RatingsEntity r : ratingsDAO.getByDriver(driverId)) {
                Rating rating = fillRatingsDomain(r);
                ratings.add(rating);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return ratings;
    }

    /**
     * returns a list of all ratings
     *
     * @return A list of all ratings
     */
    public List<Rating> allRatings() {
        List<Rating> ratings = new ArrayList<>();
        try {
            for (RatingsEntity r : ratingsDAO.findAll()) {
                Rating rating = fillRatingsDomain(r);
                ratings.add(rating);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return ratings;
    }

    /**
     * @param careInstitutionId - The ID of the careInstitution where all driver ratings must come from
     * @return A list of drivers with a list of their ratings for a specific careInstitution
     */
    public List<List<Rating>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId) {
        List<List<RatingsEntity>> ratingsEntities = ratingsDAO.getByCareInstitution(careInstitutionId);
        List<List<Rating>> ratings = new ArrayList<>();

        for (List<RatingsEntity> ra : ratingsEntities) {
            List<Rating> re = new ArrayList<>();
            for (RatingsEntity r : ra) {
                Rating rating = fillRatingsDomain(r);
                re.add(rating);
            }
            ratings.add(re);
        }
        return ratings;
    }

    /**
     * @param r - The ratingsEntity that will be filled
     * @return A filled RatingsEntity
     */
    private Rating fillRatingsDomain(RatingsEntity r) {
        UserMapper userMapper = new UserMapper();
        Rating rating = new Rating();
        rating.setClientName(userMapper.findNameById(r.getClientId()));
        rating.setDriverName(userMapper.findNameById(r.getDriverId()));
        rating.setStars(r.getSterren());
        rating.setComment(r.getBeoordeling());
        return rating;
    }

    public int getAvgRating(int id) {
        return ratingsDAO.getAvgRatings(id);
    }
}