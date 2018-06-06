package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.display.displayobject.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;
import org.han.ica.oose.boterbloem.security.AdminAndCareInstitutionAuthorization;
import org.han.ica.oose.boterbloem.security.AdminAuthorization;
import org.han.ica.oose.boterbloem.service.IDriverService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/chauffeur")
public class DriverController {

    private IDriverService driverService = new DriverService();

    @Autowired
    DriverController() {
        // Empty Constructor for Spring
    }

    /**
     * GET Driver by Id
     * @param id of Driver
     * @return Driver
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DriverEntity getDriverById(@PathVariable int id) {
        return driverService.findById(id);
    }

    /**
     * GET all Drivers
     * @return list of Drivers
     */
    @AdminAuthorization
    @RequestMapping(value = "/chauffeurs", method = RequestMethod.GET)
    public List <DriverDisplay> getAllDrivers() {
        return driverService.allDriversWithStatistics();
    }

    /**
     * GET Driver-details by specific driver
     * @param id of Driver
     * @return Driver-details
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/getChauffeur/{id}", method = RequestMethod.GET)
    public DriverDetailDisplay getDriverDetails(@PathVariable int id) {
        return driverService.getDriverDetails(id);
    }


    /**
     * POST new Driver
     * @param driverEntity = new Driver
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/create/chauffeur", method = RequestMethod.POST)
    public void createDriver(@RequestBody CreateDriverDisplay driverEntity) {
        driverService.createChauffeur(driverEntity);
    }

    /**
     * UPDATE Driver
     * @param driverEntity = Driver
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/update/chauffeur", method = RequestMethod.PUT)
    public void updateDriverDetails(@RequestBody CreateDriverDisplay driverEntity) {
        driverService.updateDriver(driverEntity);
    }

    /**
     * DELETE Driver by Id
     * @param id of Driver
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public void deleteDriverById(@PathVariable int id) {
        driverService.deleteDriverById(id, driverService.getCareInstitutionId(id));
    }

    /**
     * GET all the drivers from a specific care institution
     * @return a list of information from the drivers of a specifice care institution
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/chauffeurs/zorginstelling/{id}", method = RequestMethod.GET)
    public List <DriverDisplay> getAllDriversFromASpecificCareInstitution(@PathVariable int id) {
        return driverService.getAllDriversFromASpecificCareInstitution(id);
    }
}