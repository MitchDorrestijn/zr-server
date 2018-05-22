package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.DriverEntity;

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

    IDriverDAO DriverDAOImpl = new DriverDAOImpl(entityManager);
    IRideDAO rideDAO = new RideDAOImpl(entityManager);
    IRatingsDAO ratingsDAO = new RatingsDAOImpl(entityManager);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DriverEntity getDriverEntity(@PathVariable int id) {

        return DriverDAOImpl.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DriverEntity> getAllDriverEntity() {

        return DriverDAOImpl.findAll();
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


}
