//package org.han.ica.oose.boterbloem.controller;
//        import org.han.ica.oose.boterbloem.domain.Driver;
//        import org.han.ica.oose.boterbloem.service.DriverService;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.web.bind.annotation.CrossOrigin;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.bind.annotation.RequestMethod;
//        import org.springframework.web.bind.annotation.RestController;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/chauffeur")
//public class DriverController {
//    protected DriverService driverService = new DriverService();
//
//    @Autowired
//    DriverController() {
//        //Empty constructor
//    }
//
//    /**
//     * Method for returning all drivers
//     *
//     * @return List of chauffeurs
//     */
//    @RequestMapping(value = "/chauffeurs", method = RequestMethod.GET)
//    public List<Driver> getAllDrivers() {
//        List <Driver> drivers = new ArrayList<>();
//        drivers = driverService.getAllDrivers();
//        return drivers;
//    }
//}
