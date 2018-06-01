//package org.han.ica.oose.boterbloem.controller;
//
//import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
//import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DriverControllerTest {
//    private Driver driverA = new Driver(1, "Mitch", "Vrijwillig", new Float(173.73), 8, "NL-93-O9", 4, "Rolstoel", 5);
//    private Driver driverB = new Driver(2, "Fred", "Betaald", new Float(100.73), 5, "NL-76-03", 2, "Geen", 5);
//
//    private List<Driver> drivers = new ArrayList<>();
//    private DriverController driverController = new DriverController();
//    private DriverService driverService = mock(DriverService.class);
//
//    @Before
//    public void setup(){
//        drivers.add(driverA);
//        drivers.add(driverB);
//        driverController.driverService = driverService;
//    }
//
//    @Test
//    public void getAllDriversTest() {
//        when(driverService.getAllDrivers()).thenReturn(drivers);
//        List<Driver> testDriver = driverController.getAllDrivers();
//        assertEquals(2, testDriver.size());
//    }
//
//}
