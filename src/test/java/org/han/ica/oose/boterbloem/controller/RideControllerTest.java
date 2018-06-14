package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;
import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.Client;
import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
import org.han.ica.oose.boterbloem.domain.domainobjects.Ride;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;
import org.han.ica.oose.boterbloem.service.serviceimplementation.RideService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class RideControllerTest extends JpaTestConfig {
    protected Ride rideA = new Ride();
    protected List <Ride> rides = new ArrayList <>();
    protected RideEntity rideEntity = new RideEntity();
    protected RideDisplay rideDisplay = new RideDisplay();
    protected List <Utility> utilities = new ArrayList <>();
    protected RideService rideService = mock(RideService.class);
    private RideController rideController = new RideController();
    protected List <RideDisplay> rideDisplays = new ArrayList <>();
    protected List <UtilityEntity> utilityEntityList = new ArrayList <>();
    protected CreateRideDisplay createRideDisplay = new CreateRideDisplay();
    protected List <RideOverviewDisplay> rideOverviewDisplays = new ArrayList <>();

    @Before
    public void setup() {
        rideA.setPickUpDateTime(new Timestamp(System.currentTimeMillis()));
        rideA.setPickUpLocation("Ede");
        rideA.setDropOffLocation("Barneveld");

        Utility utility = new Utility();
        utilities.add(utility);
        rideA.setUtilities(utilities);

        rideA.setDriver(new Driver());
        rideA.setClient(new Client());
        rideA.setPaymentDescription("Graag zsm betalen");
        rideA.setPaymentStatus("Nog te betalen");
        rideA.setPaymentDueBefore(new Date(System.currentTimeMillis()).toString());
        rideA.setPriceOfRide(50.00f);
        rideA.setNumberOfcompanions(2);
        rideA.setNumberOfLuggage(5);
        rideA.setReturnRide((byte) 1);
        rideA.setCallService((byte) 0);

        createRideDisplay.setDate(new Timestamp(System.currentTimeMillis()));
        createRideDisplay.setPickUpLocation("Steenstraat 8, Arnhem");
        createRideDisplay.setDropOffLocation("Steenstraat 16, Nijmegen");
        createRideDisplay.setNumberOfcompanions(1);
        createRideDisplay.setNumberOfLuggage(0);
        createRideDisplay.setReturnRide((byte) 1);
        createRideDisplay.setCallService((byte) 0);
        createRideDisplay.setFixedRide((byte) 0);

        rides.add(rideA);
        rideDisplays.add(rideDisplay);
        rideEntity.setId(1);
        rideController.rideService = rideService;
    }

    @Test
    public void getRideByIdTest() {
        when(rideService.findById(1)).thenReturn(rideEntity);
        RideEntity rideEntity = rideController.getRideById(1);
        assertEquals(this.rideEntity, rideEntity);
    }

    @Test
    public void getRideByIdTestFailed() {
        when(rideService.findById(1)).thenReturn(rideEntity);
        RideEntity rideEntity = rideController.getRideById(1);
        assertNotEquals(2, rideEntity);
    }

    @Test
    public void getAllRidesTest() {
        when(rideService.getAllRides()).thenReturn(rideDisplays);
        List <RideDisplay> rideDisplay = rideController.getAllRides();
        assertEquals(this.rideDisplays, rideDisplay);
    }

    @Test
    public void getAllRidesTestFailed() {
        when(rideService.getAllRides()).thenReturn(rideDisplays);
        List <RideDisplay> rideDisplay = rideController.getAllRides();
        assertNotEquals(2, rideDisplay.size());
    }

    @Test
    public void getRideOverviewsTest() {
        when(rideService.getRideOverview()).thenReturn(rideOverviewDisplays);
        List <RideOverviewDisplay> rideOverviewDisplay = rideController.getRideOverview();
        assertEquals(this.rideOverviewDisplays, rideOverviewDisplay);
    }

    @Test
    public void getRideOverviewsTestFailed() {
        when(rideService.getRideOverview()).thenReturn(rideOverviewDisplays);
        List <RideOverviewDisplay> rideOverviewDisplay = rideController.getRideOverview();
        assertNotEquals(2, rideOverviewDisplay.size());
    }

    @Test
    public void createRideTest() {
        int latestId = ((Number) em.createQuery("SELECT MAX(id) FROM RideEntity ").getSingleResult()).intValue();
        utilityEntityList.add(em.find(UtilityEntity.class, "scootmobiel"));

        rideEntity.setClientEntity(em.find(ClientEntity.class, 2));
        rideEntity.setDriverEntity(em.find(DriverEntity.class, 1));
        rideEntity.setPickUpDateTime(createRideDisplay.getDate());
        rideEntity.setPickUpLocation(createRideDisplay.getPickUpLocation());
        rideEntity.setDropOffLocation(createRideDisplay.getDropOffLocation());
        rideEntity.setNumberOfcompanions(createRideDisplay.getNumberOfcompanions());
        rideEntity.setNumberOfLuggage(createRideDisplay.getNumberOfLuggage());
        rideEntity.setUtilityEntities(utilityEntityList);
        rideEntity.setReturnRide(createRideDisplay.getReturnRide());
        rideEntity.setCallService(createRideDisplay.getCallService());
        rideEntity.setFixedRide(createRideDisplay.getFixedRide());

        rideController.createRide(createRideDisplay);
        RideEntity rideEntity = (RideEntity) em.createQuery(" from RideEntity where id = :latestId").setParameter("latestId", latestId).getSingleResult();
        assertEquals(createRideDisplay.getPickUpLocation(), rideEntity.getPickUpLocation());
    }

    @Test
    public void createRideTestFailed() {
        int latestId = ((Number) em.createQuery("SELECT MAX(id) FROM RideEntity ").getSingleResult()).intValue();
        utilityEntityList.add(em.find(UtilityEntity.class, "scootmobiel"));

        rideEntity.setClientEntity(em.find(ClientEntity.class, 2));
        rideEntity.setDriverEntity(em.find(DriverEntity.class, 1));
        rideEntity.setPickUpDateTime(createRideDisplay.getDate());
        rideEntity.setPickUpLocation(createRideDisplay.getPickUpLocation());
        rideEntity.setDropOffLocation(createRideDisplay.getDropOffLocation());
        rideEntity.setNumberOfcompanions(createRideDisplay.getNumberOfcompanions());
        rideEntity.setNumberOfLuggage(createRideDisplay.getNumberOfLuggage());
        rideEntity.setUtilityEntities(utilityEntityList);
        rideEntity.setReturnRide(createRideDisplay.getReturnRide());
        rideEntity.setCallService(createRideDisplay.getCallService());
        rideEntity.setFixedRide(createRideDisplay.getFixedRide());

        rideController.createRide(createRideDisplay);
        RideEntity rideEntity = (RideEntity) em.createQuery(" from RideEntity where id = :latestId").setParameter("latestId", latestId).getSingleResult();
        assertNotEquals(createRideDisplay.getDropOffLocation(), rideEntity.getDropOffLocation());
    }
}
