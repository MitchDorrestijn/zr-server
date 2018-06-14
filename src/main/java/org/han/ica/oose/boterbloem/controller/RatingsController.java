package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.security.AdminAndCareInstitutionAuthorization;
import org.han.ica.oose.boterbloem.security.AdminAuthorization;
import org.han.ica.oose.boterbloem.domain.domainobjects.Rating;
import org.han.ica.oose.boterbloem.service.IRatingsService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/rating")
public class RatingsController {

    private IRatingsService ratingsService = new RatingsService();

    @Autowired
    RatingsController() {
        //empty constructor for spring
    }

    /**
     * GET all Rating
     * @return list of Rating
     */
    @AdminAuthorization
    @RequestMapping(value = "/ratings", method = RequestMethod.GET)
    public List <Rating> getAllRatings() {
        return ratingsService.getAllRatings();
    }

    /**
     * GET all Rating by a specific Driver
     * @param driverId of Driver
     * @return list of Driver-ratings
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/ratings/{driverId}", method = RequestMethod.GET)
    public List <Rating> getAllRatingsFromASpecificDriverById(@PathVariable int driverId) {
        return ratingsService.getAllRatingsFromASpecificDriverById(driverId);
    }

    /**
     * Method for returning all ratings from a specific care institution
     * @param careInstitutionId - The ID of the care instituton you want to get the ratings of.
     * @return A list of all ratings from a specific care institution
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/ratings/careInstitution/{careInstitutionId}", method = RequestMethod.GET)
    public List<List<Rating>> getAllRatingsFromASpecificCareInstitution(@PathVariable int careInstitutionId) {
        return ratingsService.getAllRatingsFromASpecificCareInstitution(careInstitutionId);
    }

    /**
     * Setter for property 'ratingsService'.
     * @param ratingsService Value to set for property 'ratingsService'.
     */
    public void setRatingsService(IRatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }
}