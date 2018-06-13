package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.display.displayobject.RideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.Client;
import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
import org.han.ica.oose.boterbloem.domain.domainobjects.Ride;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class RideControllerTest extends JpaTestConfig {
    protected List<Utility> utilities = new ArrayList<>();
    protected List<Ride> rides = new ArrayList<>();
    private RideController rideController = mock(RideController.class);

    protected Ride rideA = new Ride();
    protected RideEntity rideEntity = new RideEntity();
    protected List<RideDisplay> rideDisplays = new ArrayList<>();
    protected RideDisplay rideDisplay = new RideDisplay();
    protected List<RideOverviewDisplay> rideOverviewDisplays = new ArrayList<>();

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

        rides.add(rideA);
        rideDisplays.add(rideDisplay);
    }

    @Test
    public void testGetAllRides() {
        when(rideController.getAllRides()).thenReturn(rideDisplays);
        List<RideDisplay> rideDisplays = rideController.getAllRides();
        assertEquals(this.rideDisplays, rideDisplays);
    }

    @Test
    public void testGetSpecificRide() {
        when(rideController.getRideById(1)).thenReturn(rideEntity);
        RideEntity rideEntity = rideController.getRideById(1);
        assertEquals(this.rideEntity, rideEntity);
    }

    @Test
    public void testGetRideOverviews() {
        when(rideController.getRideOverview()).thenReturn(rideOverviewDisplays);
        List<RideOverviewDisplay> rideOverviewDisplays = rideController.getRideOverview();
        assertEquals(this.rideOverviewDisplays, rideOverviewDisplays);
    }
}
