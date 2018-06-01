package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.display.displayobject.*;
import org.han.ica.oose.boterbloem.service.serviceimplementation.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ride")
public class RideController {

    private IRideService rideService = new RideService();

    @Autowired
    RideController() {
        // Empty Constructor for Spring
    }

    /**
     * GET Ride by Id
     * @param id of Ride
     * @return Ride
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RideEntity getRideById(@PathVariable int id) {
        return rideService.findById(id);
    }

    /**
     * GET all Rides
     * @return list of Rides
     */
    @RequestMapping(value = "/getAllRides", method = RequestMethod.GET)
    public List <RideDisplay> getAllRides() {
        return rideService.getAllRides();
    }

    /**
     * GET all Ride information
     * @return list of Ride information
     */
    @RequestMapping(value = "/rides/overview", method = RequestMethod.GET)
    public List <RideOverviewDisplay> getRideOverview() {
        return rideService.getRideOverview();
    }

    /**
     * POST new Ride
     * @param ride = new Ride
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createRide(@RequestBody CreateRideDisplay ride) {
        rideService.createRide(ride);
    }

    /**
     * DELETE Ride by Id
     * @param id of Ride
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteRide(@PathVariable int id) {
        rideService.deleteRideById(id);
    }
}