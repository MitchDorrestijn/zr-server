package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.RatingsService;
import org.han.ica.oose.boterbloem.service.displays.RatingsDisplay;
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
     * Method for returning clients
     *
     * @return A arraylist of clients
     */
    @CrossOrigin
    @RequestMapping(value = "/ratings", method = RequestMethod.GET)
    public List<RatingsDisplay> getAllRatings() {
        return ratingsService.getAllRatings();
    }
}