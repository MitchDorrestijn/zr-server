//package org.han.ica.oose.boterbloem.service;
//
//import org.han.ica.oose.boterbloem.dao.DriverDAO;
//import org.han.ica.oose.boterbloem.domain.Driver;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DriverServiceTest {
//    private Driver driverA = new Driver(1, "Mitch", "Vrijwillig", new Float(173.73), 8, "NL-93-O9", 4, "Rolstoel", 5);
//    private Driver driverB = new Driver(2, "Fred", "Vrijwillig", new Float(122.22), 3, "NL-87-08", 2, "Rollator", 5);
//
//    private List<Driver> driverList = new ArrayList<>();
//
//    private DriverService driverService = new DriverService();
//    private DriverDAO driverDAO = mock(DriverDAO.class);
//
//    @Before
//    public void setup() throws SQLException {
//        driverList.add(driverA);
//        driverList.add(driverB);
//        driverService.driverDAO = driverDAO;
//    }
//
//    @Test
//    public void getAllDrivers() throws SQLException {
//        when(driverDAO.getAllDrivers()).thenReturn(driverList);
//        List<Driver> testDrivers = driverService.getAllDrivers();
//        assertEquals(2, testDrivers.size());
//    }
//
//
//}
