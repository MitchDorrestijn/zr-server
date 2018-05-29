package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.RideService;
import org.han.ica.oose.boterbloem.service.displays.RideOverviewDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ride")
public class RideController {
    private RideService rideService = new RideService();


    @Autowired
    public RideController() {
        //empty constructor for spring
    }

    /**
     * Method for returning a overview of rides with information
     * @return A arraylist of rides
     */
    @RequestMapping(value = "/rides/overview", method = RequestMethod.GET)
    public List<RideOverviewDisplay> getRideOverview() {
        return rideService.getRideOverview();
    }

}
