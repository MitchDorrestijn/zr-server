package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.DriverService;
import org.han.ica.oose.boterbloem.service.projection.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.service.projection.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.service.projection.DriverDisplay;
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
     *
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

    @RequestMapping(value = "/getChauffeur/{id}", method = RequestMethod.POST)
    public DriverDetailDisplay getDriverDetails (@PathVariable int id) {
        return driverService.getDriverDetails(id);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public void deleteDriver(@PathVariable int id){
        driverService.deleteDriver(id, driverService.getCareInstitutionId(id));
    }
}
