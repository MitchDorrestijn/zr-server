package org.han.ica.oose.boterbloem.controller;



import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;

import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntityPK;
import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverService;

import org.han.ica.oose.boterbloem.display.displayobject.CreateDriverDisplay;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test123")
public class TestControllerHibernate {
    private IDriverDAO driverDAOImpl = new DriverDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();
    private DriverService dr = new DriverService();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    private IClientDAO dao = new ClientDAOImpl();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DriverEntity getDriverEntity(@PathVariable int id) {

        return driverDAOImpl.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List <DriverEntity> getAllDriverEntity() {

        return driverDAOImpl.findAll();
    }

    @RequestMapping(value = "testRide/{id}", method = RequestMethod.GET)
    public int getRideCount(@PathVariable int id) {

        return rideDAO.rideCountById(id);
    }

    @RequestMapping(value = "testFloat/{id}", method = RequestMethod.GET)
    public float getFloat(@PathVariable int id) {

        return rideDAO.totalEarned(id);
    }

    @RequestMapping(value = "testAVG/{id}", method = RequestMethod.GET)
    public int getAVGsterren(@PathVariable int id) {

        return ratingsDAO.getAvgRatings(id);
    }

    @RequestMapping(value = "testPutDriver", method = RequestMethod.POST)
    public void createDriverTest(@RequestBody DriverEntity driverEntity) {
        driverDAOImpl.add(driverEntity);
    }

    @RequestMapping(value = "testPutDisplay", method = RequestMethod.POST)
    public void createDisplayTest(@RequestBody CreateDriverDisplay driverEntity) {
        dr.createChauffeur(driverEntity);
    }

    @RequestMapping(value = "testGetcar", method = RequestMethod.GET)
    public DrivercarEntity get123() {
        DrivercarEntityPK drivercarEntityPK = new DrivercarEntityPK();
        drivercarEntityPK.setDriverId(1);
        return drivercarDAO.findCarById(1);
    }

    @RequestMapping(value = "testGetDriver", method = RequestMethod.GET)
    public CreateDriverDisplay get12345() {

        return dr.getThisThing();
    }

    @RequestMapping(value = "teset", method = RequestMethod.GET)
    public ClientEntity asd() {
        return dao.findById(2);
    }
}
