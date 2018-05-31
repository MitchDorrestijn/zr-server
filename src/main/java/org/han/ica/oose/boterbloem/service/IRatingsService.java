package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainobjects.Ratings;


import java.util.List;

public interface IRatingsService {
    /**
     * @return A list of all ratings from the database
     */
    public List<Ratings> getAllRatings();

    /**
     * Method for returning all ratings from a specific care institution
     * @param careInstitutionId - The ID of the care instituton you want to get the ratings of.
     * @return A list of all ratings from a specific care institution
     */
    List<List<Ratings>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId);
}
