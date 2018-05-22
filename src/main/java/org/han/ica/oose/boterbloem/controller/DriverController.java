package org.han.ica.oose.boterbloem.controller;
import org.han.ica.oose.boterbloem.domain.Driver;
import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.service.DriverService;
import org.han.ica.oose.boterbloem.service.projection.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.service.projection.DriverDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chauffeur")
public class DriverController {
    protected DriverService driverService = new DriverService();

    @Autowired
    DriverController() {
        //Empty constructor
    }

    /**
     * Method for returning all drivers
     *
     * @return List of chauffeurs
     */
    @RequestMapping(value = "/chauffeurs", method = RequestMethod.GET)
    public List<DriverDisplay> getAllDrivers() {
        return driverService.allDriversWithStatistics();
    }

    /**
     * Method for returning detailed information of a driver
     *
     * @return List with information of a specific chauffeur
     */
    @RequestMapping(value = "/chauffeurdetail/{id}", method = RequestMethod.GET)
    public List<DriverDetailDisplay> getDriverDetails() {
        return driverService.getDriverDetails();
    }

}
