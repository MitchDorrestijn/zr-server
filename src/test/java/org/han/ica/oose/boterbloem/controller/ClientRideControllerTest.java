package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.display.displayobject.ClientRideDisplay;
import org.han.ica.oose.boterbloem.service.serviceimplementation.ClientRideService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class ClientRideControllerTest extends JpaTestConfig {

    ClientRideController clientRideController = new ClientRideController();
    IRideDAO rideDAO =  new RideDAOImpl();
    IClientDAO clientDAO =  new ClientDAOImpl();
    ClientRideService clientRideService =  new ClientRideService();

   @Before
   public void setup(){
       rideDAO.setEntityManager(em);
       clientDAO.setEntityManager(em);
       clientRideService.setRideDAO(rideDAO);
       clientRideService.setClientDAO(clientDAO);
       clientRideController.setClientRideService(clientRideService);

   }


    @Test
    public void getRidesFromSpecificClientByIdTest(){
     List<ClientRideDisplay> clientRideDisplays =  clientRideController.getRidesFromSpecificClientById(2);
       assertEquals(4,clientRideDisplays.size());
    }
}
