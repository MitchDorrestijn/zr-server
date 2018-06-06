package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainobjects.Rating;

import java.util.List;

public interface IRatingsService {
    /**
     * GET all Rating
     * @return list of Rating
     */
    List<Rating> getAllRatings();

    /**
     * GET all Rating by a specific Driver
     * @param id of Driver
     * @return list of Driver-ratings
     */
    List<Rating> getAllRatingsFromASpecificDriverById(int id);


    /**
     * Method for returning all ratings from a specific care institution
     * @param careInstitutionId - The ID of the care instituton you want to get the ratings of.
     * @return A list of all ratings from a specific care institution
     */
    List<List<Rating>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId);
}
