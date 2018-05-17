package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.daoHibernate.DriverDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.daoHibernate.IRideDAO;
import org.han.ica.oose.boterbloem.daoHibernate.RideDAOImpl;
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

}
