package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.display.displaymapper.RideDisplayMapper;
import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RidesByCareinstitutionDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.*;
import org.han.ica.oose.boterbloem.domain.domainobjects.Ride;
import org.han.ica.oose.boterbloem.service.serviceimplementation.RideService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class additionalRideControllerTests extends JpaTestConfig {

    RideController rideController = new RideController();
    RideService rideService = new RideService();

    private IRideDAO rideDAO = new RideDAOImpl();
    private IClientDAO clientDAO = new ClientDAOImpl();
    private IDriverDAO driverDAO = new DriverDAOImpl();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();
    private IUtilityDAO utilityDAO = new UtilityDAOImpl();
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();
    private RideMapper rideMapper = new RideMapper();
    private UtilityMapper utilityMapper = new UtilityMapper();
    private RideDisplayMapper rideDisplayMapper = new RideDisplayMapper();

    private DriverMapper driverMapper = new DriverMapper();
    private ClientMapper clientMapper = new ClientMapper();

    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    private LimitationMapper limitationMapper = new LimitationMapper();

    @Before
    public void setup() {
    rideDAO.setEntityManager(em);
    clientDAO.setEntityManager(em);
    driverDAO.setEntityManager(em);
    drivercarDAO.setEntityManager(em);
    utilityDAO.setEntityManager(em);
    ratingsDAO.setEntityManager(em);
    clientlimitationDAO.setEntityManager(em);


    driverMapper.setRideDAO(rideDAO);
    driverMapper.setRatingsDAO(ratingsDAO);
    driverMapper.setDriverDAO(driverDAO);
    driverMapper.setDrivercarDAO(drivercarDAO);

    utilityMapper.setUtilityDAO(utilityDAO);

    clientMapper.setClientlimitationDAO(clientlimitationDAO);
    clientMapper.setLimitationMapper(limitationMapper);

    rideMapper.setRideDAO(rideDAO);
    rideMapper.setDrivercarDAO(drivercarDAO);
    rideMapper.setDriverMapper(driverMapper);
    rideMapper.setUtilityMapper(utilityMapper);
    rideMapper.setClientMapper(clientMapper);

    rideDisplayMapper.setRideMapper(rideMapper);

    rideService.setClientDAO(clientDAO);
    rideService.setDriverDAO(driverDAO);
    rideService.setRideDAO(rideDAO);
    rideService.setUtilityMapper(utilityMapper);
    rideService.setRideDisplayMapper(rideDisplayMapper);
    rideService.setRideMapper(rideMapper);

    rideController.setRideService(rideService);

    }

    @Test
    public void ControllerFirst(){
        List<RideOverviewDisplay> rideOverviewDisplayList = rideController.paymentsAtCareinstitution(1);
        assertEquals(5,rideOverviewDisplayList.size());
    }

    @Test
    public void deleteRideTest(){
        rideController.deleteRide(1);
        List<RideDisplay> rideDisplays =  rideController.getAllRides();
        assertEquals(11,rideDisplays.size());
    }
    @Test
    public void getCareRide(){
        List<RidesByCareinstitutionDisplay> ridesByCareinstitutionDisplays = rideController.ridesFromCareinstitution(1);
       assertEquals(5,ridesByCareinstitutionDisplays.size());
       RideEntity rideEntity = rideController.getRideById(2);
        assertEquals(2,rideEntity.getId());
    }

    @Test
    public void updateRide(){
        RideEntity rideEntity =  new RideEntity();
        rideEntity =  em.find(RideEntity.class, 1);

        CreateRideDisplay createRideDisplay = new CreateRideDisplay();
        createRideDisplay.setPickUpLocation("Steenstraat 2, Arnhem");
        createRideDisplay.setClientId(1);
        createRideDisplay.setDate(rideEntity.getPickUpDateTime());
        createRideDisplay.setCallService(rideEntity.getCallService());
        createRideDisplay.setDropOffLocation(rideEntity.getDropOffLocation());
        createRideDisplay.setFixedRide(rideEntity.getFixedRide());
        createRideDisplay.setReturnRide(rideEntity.getReturnRide());
        createRideDisplay.setNumberOfcompanions(rideEntity.getNumberOfcompanions());
        createRideDisplay.setNumberOfLuggage(rideEntity.getNumberOfLuggage());


        rideController.updateRide(createRideDisplay);

        assertEquals("Steenstraat 2, Arnhem", em.find(RideEntity.class, 1).getPickUpLocation());

    }
}
