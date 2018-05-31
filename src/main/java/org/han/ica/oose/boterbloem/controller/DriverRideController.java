package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.IDriverRideService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverRideService;
import org.han.ica.oose.boterbloem.display.displayobject.DriverRideDisplay;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ride/driver")
public class DriverRideController {

    private IDriverRideService driverRideService = new DriverRideService();

    @Autowired
    DriverRideController() {
        // Empty Constructor for Spring
    }

    /**
     * GET all Rides by a specific Driver
     * @param id of Driver
     * @return list of Driver-rides
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List <DriverRideDisplay> getRidesFromSpecificDriverById(@PathVariable int id) {
        return driverRideService.getRidesFromSpecificDriverId(id);
    }

}