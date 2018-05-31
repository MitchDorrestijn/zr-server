//package org.han.ica.oose.boterbloem.dao;
//
//import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DriverDAOTest {
//    private DriverDAO driverDAO;
//
//    @Before
//    public void setup() throws Exception {
//        driverDAO = new DriverDAO();
//        driverDAO.dao.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/create_script.sql'").execute();
//        driverDAO.dao.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/insert_script.sql'").execute();
//    }
//
//    @Test
//    public void hasConnection() {
//        assertTrue(driverDAO.dao.hasConnection());
//    }
//
//    @Test
//    public void getAllDrivers() {
//        List<Driver> driverList = driverDAO.getAllDrivers();
//        assertEquals(9, driverList.get(0).getId());
//        assertEquals("Mitch Zantingh", driverList.get(0).getName());
//        assertEquals("Vrijwillig", driverList.get(0).getTypeOfPayment());
//        assertEquals(new Float(0.0), driverList.get(0).getTotalEarned());
//        assertEquals(0, driverList.get(0).getTotalRides());
//        assertEquals("af-83-dc", driverList.get(0).getNumberPlate());
//        assertEquals(1, driverList.get(0).getNumberOfPassengers());
//        assertEquals("rolstoel", driverList.get(0).getSegment());
//        assertEquals(3, driverList.get(0).getRating());
//
//        assertNotEquals(1, driverList.get(0).getId());
//        assertNotEquals("Fred Figglehorn", driverList.get(0).getName());
//        assertNotEquals("Betaald", driverList.get(0).getTypeOfPayment());
//        assertNotEquals(new Float(80.4), driverList.get(0).getTotalEarned());
//        assertNotEquals(3, driverList.get(0).getTotalRides());
//        assertNotEquals("NL-85-WD", driverList.get(0).getNumberPlate());
//        assertNotEquals(16, driverList.get(0).getNumberOfPassengers());
//        assertNotEquals("Scootmobiel", driverList.get(0).getSegment());
//        assertNotEquals(5, driverList.get(0).getRating());
//    }
//
//}
//package org.han.ica.oose.boterbloem.dao;
//
//import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DriverDAOTest {
//    private DriverDAO driverDAO;
//
//    @Before
//    public void setup() throws Exception {
//        driverDAO = new DriverDAO();
//        driverDAO.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/create_script.sql'").execute();
//        driverDAO.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/insert_script.sql'").execute();
//    }
//
//    @Test
//    public void hasConnection() {
//        assertTrue(driverDAO.CONNECTION_DAO.hasConnection());
//    }
//
//    @Test
//    public void getAllDrivers() {
//        List<Driver> driverList = driverDAO.getAllDrivers();
//        assertEquals(9, driverList.get(0).getId());
//        assertEquals("Mitch Zantingh", driverList.get(0).getName());
//        assertEquals("Vrijwillig", driverList.get(0).getTypeOfPayment());
//        assertEquals(new Float(0.0), driverList.get(0).getTotalEarned());
//        assertEquals(0, driverList.get(0).getTotalRides());
//        assertEquals("af-83-dc", driverList.get(0).getNumberPlate());
//        assertEquals(1, driverList.get(0).getNumberOfPassengers());
//        assertEquals("rolstoel", driverList.get(0).getSegment());
//        assertEquals(3, driverList.get(0).getRating());
//
//        assertNotEquals(1, driverList.get(0).getId());
//        assertNotEquals("Fred Figglehorn", driverList.get(0).getName());
//        assertNotEquals("Betaald", driverList.get(0).getTypeOfPayment());
//        assertNotEquals(new Float(80.4), driverList.get(0).getTotalEarned());
//        assertNotEquals(3, driverList.get(0).getTotalRides());
//        assertNotEquals("NL-85-WD", driverList.get(0).getNumberPlate());
//        assertNotEquals(16, driverList.get(0).getNumberOfPassengers());
//        assertNotEquals("Scootmobiel", driverList.get(0).getSegment());
//        assertNotEquals(5, driverList.get(0).getRating());
//    }
//
//}
