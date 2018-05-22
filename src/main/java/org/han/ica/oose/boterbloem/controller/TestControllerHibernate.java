package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.domain.Driver;
import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.entity.DriverEntity;

import org.han.ica.oose.boterbloem.service.DriverService;
import org.han.ica.oose.boterbloem.service.projection.CreateDriverDisplay;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


@RestController
@RequestMapping("/test123")
public class TestControllerHibernate {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    IDriverDAO driverDAOImpl = new DriverDAOImpl(entityManager);
    IRideDAO rideDAO = new RideDAOImpl(entityManager);
    IRatingsDAO ratingsDAO = new RatingsDAOImpl(entityManager);
    DriverService dr = new DriverService();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DriverEntity getDriverEntity(@PathVariable int id) {

        return driverDAOImpl.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DriverEntity> getAllDriverEntity() {

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

    @RequestMapping( value = "testPutDriver", method = RequestMethod.POST)
    public void createDriverTest(@RequestBody  DriverEntity driverEntity){
     driverDAOImpl.add(driverEntity);
    }

//    @CrossOrigin
//    @RequestMapping(value = "/testPutDriver", method = RequestMethod.POST)
//    public ResponseEntity<String> createDriverTest(@RequestBody CreateDriverDisplay createDriverDisplay) {
//        dr.createChauffeur(createDriverDisplay);
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<>(headers, HttpStatus.CREATED);
//    }


}
