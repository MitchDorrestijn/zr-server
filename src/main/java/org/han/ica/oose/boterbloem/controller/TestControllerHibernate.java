package org.han.ica.oose.boterbloem.controller;



import org.han.ica.oose.boterbloem.daoHibernate.DriverDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IDriverDAOm;


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

    IDriverDAOm DriverDAOImpl = new DriverDAOImpl(entityManager);


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DriverEntity getDriverEntity(@PathVariable int id) {

        return DriverDAOImpl.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DriverEntity> getAllDriverEntity() {

        return DriverDAOImpl.findAll();
    }


}
