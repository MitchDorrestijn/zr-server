package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.DriverRideService;
import org.han.ica.oose.boterbloem.service.displays.DriverRideDisplay;
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

    @RequestMapping(value = "/{driverId}", method = RequestMethod.GET)
    public List <DriverRideDisplay> getRidesFromSpeficDriver(@PathVariable int driverId) {
        return rideService.getRidesFromSpeficDriver(driverId);
    }
}