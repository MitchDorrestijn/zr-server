package org.han.ica.oose.boterbloem.controller;
import org.han.ica.oose.boterbloem.domain.Driver;
import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.service.DriverService;
import org.han.ica.oose.boterbloem.service.projection.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.service.projection.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.service.projection.DriverDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/create/chauffeur", method = RequestMethod.POST)
    public void createDriverDetails(@RequestBody CreateDriverDisplay driverEntity) {
         driverService.createChauffeur(driverEntity);
    }

    @RequestMapping(value = "/getChauffeur/{id}", method = RequestMethod.POST)
    public DriverDetailDisplay getDriverDetails (@PathVariable int id) {
        return driverService.getDriverDetails(id);
    }

}
