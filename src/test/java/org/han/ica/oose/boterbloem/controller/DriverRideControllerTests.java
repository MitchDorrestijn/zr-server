package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.display.displayobject.DriverRideDisplay;
import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverRideService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class DriverRideControllerTests extends JpaTestConfig {

    DriverRideController driverRideController =  new DriverRideController();
    DriverRideService driverRideService =  new DriverRideService();
    IRideDAO rideDAO =  new RideDAOImpl();


    @Before
    public void setup(){
        rideDAO.setEntityManager(em);
        driverRideService.setRideDAO(rideDAO);
        driverRideController.setDriverRideService(driverRideService);
    }

    @Test
    public void getDriverForRideTest(){
     List<DriverRideDisplay> driverRideDisplayList =  driverRideController.getRidesFromSpecificDriverById(1);
       assertEquals(3,driverRideDisplayList.size());
    }

}
