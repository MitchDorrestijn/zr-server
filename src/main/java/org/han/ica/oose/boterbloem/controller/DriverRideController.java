package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.display.displayobject.DriverRideDisplay;
import org.han.ica.oose.boterbloem.security.AdminAndCareInstitutionAuthorization;
import org.han.ica.oose.boterbloem.service.IDriverRideService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/ride/driver")
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
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List <DriverRideDisplay> getRidesFromSpecificDriverById(@PathVariable int id) {
        return driverRideService.getRidesFromSpecificDriverId(id);
    }

}