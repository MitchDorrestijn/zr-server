package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainObjects.Ratings;

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
}
