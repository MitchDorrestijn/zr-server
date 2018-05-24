package org.han.ica.oose.boterbloem.controller;
import org.han.ica.oose.boterbloem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
/*    @RequestMapping(value = "/chauffeurs", method = RequestMethod.GET)
    public List<DriverDisplay> getAllDrivers() {
        return driverService.allDriversWithStatistics();
    }

    *//**
     * Method for returning detailed information of a driver
     *
     * @return List with information of a specific chauffeur
     *//*
    @RequestMapping(value = "/create/chauffeur", method = RequestMethod.POST)
    public void createDriverDetails(CreateDriverDisplay driverEntity) {
        driverService.createChauffeur(driverEntity);
    }*/

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public void deleteDriver(@PathVariable int id){
        driverService.deleteDriver(id, driverService.getCareInstitutionId(id));
    }
/*    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientEntity getClientById(@PathVariable int id) throws SQLException {
        return clientService.findById(id);
    }
}*/

}