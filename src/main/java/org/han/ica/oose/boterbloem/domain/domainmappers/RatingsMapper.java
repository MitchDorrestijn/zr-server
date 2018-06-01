package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.domain.domainobjects.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.service.serviceimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;

import java.util.*;
import java.util.logging.*;

public class RatingsMapper {
    private static final Logger LOGGER = Logger.getLogger(RatingsService.class.getName());

    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();

    /**
     * @param driverId the driverID where you wnat to get the specific ratings from
     * @return a list of ratings from a specific driver
     */
    public List<Ratings> getAllRatingsFromASpecificDriver(int driverId) {
        List<Ratings> ratings = new ArrayList<>();
        try {
            for (RatingsEntity r : ratingsDAO.getByDriver(driverId)) {
                Ratings rating = fillRatingsDomain(r);
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
    public List<Ratings> allRatings() {
        List<Ratings> ratings = new ArrayList<>();
        try {
            for (RatingsEntity r : ratingsDAO.findAll()) {
                Ratings rating = fillRatingsDomain(r);
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
    public List<List<Ratings>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId) {
        List<List<RatingsEntity>> ratingsEntities = ratingsDAO.getByCareInstitution(careInstitutionId);
        List<List<Ratings>> ratings = new ArrayList<>();

        for (List<RatingsEntity> ra : ratingsEntities) {
            List<Ratings> re = new ArrayList<>();
            for (RatingsEntity r : ra) {
                Ratings rating = fillRatingsDomain(r);
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
    private Ratings fillRatingsDomain(RatingsEntity r) {
        UserMapper userMapper = new UserMapper();
        Ratings rating = new Ratings();
        rating.setClientName(userMapper.findNameById(r.getClientId()));
        rating.setDriverName(userMapper.findNameById(r.getDriverId()));
        rating.setStars(r.getSterren());
        rating.setComment(r.getBeoordeling());
        return rating;
    }
}