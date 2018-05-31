package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.domainObjects.Ratings;
import org.han.ica.oose.boterbloem.service.serviceImplementation.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rating")
public class RatingsController {

    RatingsService ratingsService = new RatingsService();

    @Autowired
    RatingsController() {
        //empty constructor for spring
    }

    /**
     * Method for returning all ratings
     *
     * @return A arraylist of ratings
     */
    @CrossOrigin
    @RequestMapping(value = "/ratings", method = RequestMethod.GET)
    public List<Ratings> getAllRatings() {
        return ratingsService.getAllRatings();
    }


    /**
     * Method for returning ratings of a specific driver
     *
     * @param driverId - id of the Driver
     * @return A arraylist of ratings
     */
    @RequestMapping(value = "/ratings/{driverId}", method = RequestMethod.GET)
    public List<Ratings> getAllRatingsFromASpecificDriver(@PathVariable int driverId) {
        return ratingsService.getAllRatingsFromASpecificDriver(driverId);
    }

    /**
     * Method for returning all ratings from a specific care institution
     * @param careInstitutionId - The ID of the care instituton you want to get the ratings of.
     * @return A list of all ratings from a specific care institution
     */
    @RequestMapping(value = "/ratings/careInstitution/{careInstitutionId}", method = RequestMethod.GET)
    public List<List<Ratings>> getAllRatingsFromASpecificCareInstitution(@PathVariable int careInstitutionId) {
        return ratingsService.getAllRatingsFromASpecificCareInstitution(careInstitutionId);
    }


}