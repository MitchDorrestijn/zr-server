package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.domainObjects.Ratings;
import org.han.ica.oose.boterbloem.service.IRatingsService;
import org.han.ica.oose.boterbloem.service.serviceImplementation.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}