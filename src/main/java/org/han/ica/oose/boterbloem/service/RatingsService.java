package org.han.ica.oose.boterbloem.service;


import org.han.ica.oose.boterbloem.domain.domainImplementation.Ratings;
import org.han.ica.oose.boterbloem.mapper.RatingsMapper;


import java.util.List;

public class RatingsService implements IRatingsService {

    private RatingsMapper ratingsMapper = new RatingsMapper();

    public RatingsService() {
        //Empty constructor
    }

    /**
     * @return A list of all ratings from the database
     */
    public List<Ratings> getAllRatings() {
        return ratingsMapper.allRatings();
    }

    public List<Ratings> getAllRatingsFromASpecificDriver(int driverId) {
        return ratingsMapper.ratingByDriver(driverId);
    }
}