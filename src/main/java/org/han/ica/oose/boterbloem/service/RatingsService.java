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


    /***
     * @param driverId - id of the driver where you want to get the ratings from
     * @return A list of all the given ratings for the specific driver
     */
    public List<Ratings> getAllRatingsFromASpecificDriver(int driverId) {
        return ratingsMapper.getAllRatingsFromASpecificDriver(driverId);
    }

    /**
     * @param careInstitutionId - The ID of the care instituton you want to get the ratings of.
     * @return A list of ratings of a specific care institution
     */
    @Override
    public List<List<Ratings>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId) {
        return ratingsMapper.getAllRatingsFromASpecificCareInstitution(careInstitutionId);
    }

}