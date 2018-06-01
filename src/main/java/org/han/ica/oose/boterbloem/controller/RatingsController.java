package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.*;
import org.han.ica.oose.boterbloem.domain.domainobjects.*;
import org.han.ica.oose.boterbloem.service.serviceimplementation.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rating")
public class RatingsController {

    private IRatingsService ratingsService = new RatingsService();

    @Autowired
    RatingsController() {
        //empty constructor for spring
    }

    /**
     * GET all Ratings
     * @return list of Ratings
     */
    @CrossOrigin
    @RequestMapping(value = "/ratings", method = RequestMethod.GET)
    public List <Ratings> getAllRatings() {
        return ratingsService.getAllRatings();
    }

    /**
     * GET all Ratings by a specific Driver
     * @param driverId of Driver
     * @return list of Driver-ratings
     */
    @RequestMapping(value = "/ratings/{driverId}", method = RequestMethod.GET)
    public List <Ratings> getAllRatingsFromASpecificDriverById(@PathVariable int driverId) {
        return ratingsService.getAllRatingsFromASpecificDriverById(driverId);
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