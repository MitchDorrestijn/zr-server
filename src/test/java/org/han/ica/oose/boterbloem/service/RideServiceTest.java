package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.controller.RideControllerTest;
import org.han.ica.oose.boterbloem.display.displayobject.RideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.service.serviceimplementation.RideService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RideServiceTest extends RideControllerTest {
    RideService rideService = mock(RideService.class);

    @Before
    public void setup() {
        super.setup();
    }

    @Override
    public void testGetAllRides() {
        when(rideService.getAllRides()).thenReturn(rideDisplays);
        List<RideDisplay> rideDisplays = rideService.getAllRides();
        assertEquals(this.rideDisplays, rideDisplays);
    }

    @Override
    public void testGetRideOverviews() {
        when(rideService.getRideOverview()).thenReturn(rideOverviewDisplays);
        List<RideOverviewDisplay> rideOverviewDisplays = rideService.getRideOverview();
        assertEquals(this.rideOverviewDisplays, rideOverviewDisplays);
    }
}
