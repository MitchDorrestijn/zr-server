package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainobjects.Ratings;

import java.util.List;

public interface IRatingsService {
    /**
     * GET all Ratings
     * @return list of Ratings
     */
    List<Ratings> getAllRatings();

    /**
     * GET all Ratings by a specific Driver
     * @param id of Driver
     * @return list of Driver-ratings
     */
    List<Ratings> getAllRatingsFromASpecificDriverById(int id);


    /**
     * Method for returning all ratings from a specific care institution
     * @param careInstitutionId - The ID of the care instituton you want to get the ratings of.
     * @return A list of all ratings from a specific care institution
     */
    List<List<Ratings>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId);
}
