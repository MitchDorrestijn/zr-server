package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.display.displaymapper.DriverDisplayMapper;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.DriverMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
import org.han.ica.oose.boterbloem.domain.domainobjects.DriverCar;
import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * TODO: This is unable to be tested correctly, as the driver part of the application isn't refactored to mappers
 */
@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class DriverControllerTest extends JpaTestConfig {
    private DriverCar driverCarA = new DriverCar();
    private DriverCar driverCarB = new DriverCar();
    private DriverCar driverCarC = new DriverCar();

    private Driver driverA = new Driver();
    private Driver driverB = new Driver();

    private List<Driver> drivers = new ArrayList<>();
    private List<DriverCar> driverCarsA = new ArrayList<>();
    private List<DriverCar> driverCarsB = new ArrayList<>();

    private DriverDisplay driverDisplay = new DriverDisplay();

    private DriverDisplayMapper driverDisplayMapper = new DriverDisplayMapper();
    private DriverController driverController = new DriverController();
    private DriverService driverService = mock(DriverService.class);

    @Before
    public void setup(){
        driverCarA.setUtility("Wandelstok");
        driverCarA.setNumberPlate("23-GH-34");
        driverCarA.setNumberOfPassengers(5);
        driverCarA.setSegment("A");
        driverCarA.setBrand("Volvo");

        driverCarB.setUtility("Rollator");
        driverCarB.setNumberPlate("76-AS-23");
        driverCarB.setNumberOfPassengers(2);
        driverCarB.setSegment("B");
        driverCarB.setBrand("Volkswagen");

        driverCarC.setUtility("Rolstoel");
        driverCarC.setNumberPlate("45-FDT-3");
        driverCarC.setNumberOfPassengers(7);
        driverCarC.setSegment("C");
        driverCarC.setBrand("BMW");

        driverCarsA.add(driverCarA);
        driverCarsA.add(driverCarB);

        driverCarsB.add(driverCarC);

        driverA.setId(1);
        driverA.setVerification((byte) 1);
        driverA.setTypeOfPayment("PayPal");
        driverA.setImage("imgur.com/afbeelding");
        driverA.setAccountnr("NL23INGB1982454321");
        driverA.setDriverCars(driverCarsA);
        driverA.setTotalRides(500);
        driverA.setTotalRides(10);

        driverB.setId(2);
        driverB.setVerification((byte) 0);
        driverB.setTypeOfPayment("iDeal");
        driverB.setImage("imgur.com/nogEenAfbeelding");
        driverB.setAccountnr("NL76SNSB1908765421");
        driverB.setDriverCars(driverCarsB);
        driverB.setTotalRides(50);
        driverB.setTotalRides(1);

        drivers.add(driverA);
        drivers.add(driverB);

        driverDisplay = driverDisplayMapper.fillDisplay(driverA);
    }

    @Test
    public void testGetAllDrivers() {
    }

}