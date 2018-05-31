package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverService;
import org.han.ica.oose.boterbloem.display.displayobject.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @return List of chauffeurs
     */
    @RequestMapping(value = "/chauffeurs", method = RequestMethod.GET)
    public List<DriverDisplay> getAllDrivers() {
        return driverService.allDriversWithStatistics();
    }

    /**
     * Method for creating a new driver
     *
     * @return List with information of a specific chauffeur
     */
    @RequestMapping(value = "/create/chauffeur", method = RequestMethod.POST)
    public void createDriverDetails(@RequestBody CreateDriverDisplay driverEntity) {
         driverService.createChauffeur(driverEntity);
    }

    @RequestMapping(value = "/getChauffeur/{id}", method = RequestMethod.GET)
    public DriverDetailDisplay getDriverDetails (@PathVariable int id) {
        return driverService.getDriverDetails(id);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public void deleteDriver(@PathVariable int id){
        driverService.deleteDriver(id, driverService.getCareInstitutionId(id));
    }

    @RequestMapping(value = "/update/chauffeur", method = RequestMethod.PUT)
    public void updateDriverDetails(@RequestBody CreateDriverDisplay driverEntity) {
        driverService.updateDriver(driverEntity);
    }


    /**
     * Get all the drivers from a specific care institution
     * @return a list of information from the drivers of a specifice care institution
     */
    @RequestMapping(value = "/chauffeurs/zorginstelling/{id}", method = RequestMethod.GET)
    public List<DriverDisplay> getAllDriversFromASpecificCareInstitution(@PathVariable int id) {
        return driverService.getAllDriversFromASpecificCareInstitution(id);
    }



}
