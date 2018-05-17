package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.daoHibernate.DriverDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IDriverDAOm;
import org.han.ica.oose.boterbloem.entity.DriverEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/test123")
public class TestControllerHibernate {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    IDriverDAOm driverEntityManager = new DriverDAOImpl(entityManager);


    public TestControllerHibernate() {

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DriverEntity getDriverEntity(@PathVariable int id) {

        return driverEntityManager.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DriverEntity> getAllDriverEntity() {

        return driverEntityManager.findAll();
    }


}
