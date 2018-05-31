package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.RideService;
import org.han.ica.oose.boterbloem.service.displays.CreateRideDisplay;
import org.han.ica.oose.boterbloem.service.displays.RideDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ride")
public class RideController {

    private RideService rideService = new RideService();

    @Autowired
    RideController() {
        // Empty Constructor for Spring
    }

    /**
     * @return list of all rides
     */
    @RequestMapping(value = "/getAllRides", method = RequestMethod.GET)
    public List <RideDisplay> getAllRides() {
        return rideService.getAllRides();
    }

    /**
     * @param createRideDisplay = create a ride
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createRide(@RequestBody CreateRideDisplay createRideDisplay) {
        rideService.createRide(createRideDisplay);
    }

    /**
     * @param id the Ride
     */
    @RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
    public void deleteRide(@PathVariable int id) {
        rideService.deleteRide(id);
    }

}