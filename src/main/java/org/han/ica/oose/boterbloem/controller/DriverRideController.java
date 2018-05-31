package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverRideService;
import org.han.ica.oose.boterbloem.display.displayobject.DriverRideDisplay;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ride/driver")
public class DriverRideController {
    private DriverRideService rideService = new DriverRideService();

    @Autowired
    DriverRideController() {
        // Empty Constructor for Spring
    }

    /**
     * @param driverId of Driver
     * @return list of driver rides
     */
    @RequestMapping(value = "/{driverId}", method = RequestMethod.GET)
    public List <DriverRideDisplay> getRidesFromSpecificDriver(@PathVariable int driverId) {
        return rideService.getRidesFromSpecificDriver(driverId);
    }
}