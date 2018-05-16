package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.dao.DriverEntityManagerImpl;
import org.han.ica.oose.boterbloem.dao.IDriverEntityManager;
import org.han.ica.oose.boterbloem.entity.DriverEntity;


import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@RestController
@RequestMapping("/test123")
public class TestControllerHibernate {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    IDriverEntityManager driverEntityManager = new DriverEntityManagerImpl(entityManager);


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DriverEntity getDriverEntity(@PathVariable int id) {

        return driverEntityManager.findById(id);
    }


}
