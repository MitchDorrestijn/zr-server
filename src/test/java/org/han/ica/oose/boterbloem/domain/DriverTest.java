package org.han.ica.oose.boterbloem.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverTest {
    private Driver driver;

    @Before
    public void setUp() throws Exception {
        driver = new Driver(1, "Mitch", "Vrijwillig", new Float(173.73), 8, "NL-93-O9", 4, "Rolstoel", 5);
    }

    @Test
    public void getId() {
        assertEquals(1, driver.getId());
        assertNotEquals(2, driver.getId());
    }

    @Test
    public void setId() {
        driver.setId(2);
        assertEquals(2, driver.getId());
        assertNotEquals(1, driver.getId());
    }

    @Test
    public void getName() {
        assertEquals("Mitch", driver.getName());
        assertNotEquals("Fred", driver.getName());
    }

    @Test
    public void setName() {
        driver.setName("Fred");
        assertEquals("Fred", driver.getName());
        assertNotEquals("Mitch", driver.getName());
    }

    @Test
    public void getTypeOfPayment() {
        assertEquals("Vrijwillig", driver.getTypeOfPayment());
        assertNotEquals("Betaald", driver.getTypeOfPayment());
    }

    @Test
    public void setTypeOfPayment() {
        driver.setTypeOfPayment("Betaald");
        assertEquals("Betaald", driver.getTypeOfPayment());
        assertNotEquals("Vrijwillig", driver.getTypeOfPayment());
    }

    @Test
    public void getTotalEarned() {
        assertEquals(new Float(173.73), driver.getTotalEarned());
        assertNotEquals(new Float(122.50), driver.getTotalEarned());
    }

    @Test
    public void setTotalEarned() {
        driver.setTotalEarned(new Float(22.34));
        assertEquals(new Float(22.34), driver.getTotalEarned());
        assertNotEquals(new Float(173.73), driver.getTotalEarned());
    }

    @Test
    public void getTotalRides() {
        assertEquals(8, driver.getTotalRides());
        assertNotEquals(9, driver.getTotalRides());
    }

    @Test
    public void setTotalRides() {
        driver.setTotalRides(9);
        assertEquals(9, driver.getTotalRides());
        assertNotEquals(8, driver.getTotalRides());
    }

    @Test
    public void getNumberPlate() {
        assertEquals("NL-93-O9", driver.getNumberPlate());
        assertNotEquals("NL-08-23", driver.getNumberPlate());
    }

    @Test
    public void setumberPlate() {
        driver.setNumberPlate("NL-08-23");
        assertEquals("NL-08-23", driver.getNumberPlate());
        assertNotEquals("NL-93-O9", driver.getNumberPlate());
    }

    @Test
    public void getNumberOfPassengers() {
        assertEquals(4, driver.getNumberOfPassengers());
        assertNotEquals(5, driver.getNumberOfPassengers());
    }

    @Test
    public void setNumberOfPassengers() {
        driver.setNumberOfPassengers(5);
        assertEquals(5, driver.getNumberOfPassengers());
        assertNotEquals(4, driver.getNumberOfPassengers());
    }

    @Test
    public void getSegment() {
        assertEquals("Rolstoel", driver.getSegment());
        assertNotEquals("Scootmobiel", driver.getSegment());
    }

    @Test
    public void setSegment() {
        driver.setSegment("Scootmobiel");
        assertEquals("Scootmobiel", driver.getSegment());
        assertNotEquals("Rolstoel", driver.getSegment());
    }

    @Test
    public void getRating() {
        assertEquals(5, driver.getRating());
        assertNotEquals(4, driver.getRating());
    }

    @Test
    public void setRating() {
        driver.setRating(4);
        assertEquals(4, driver.getRating());
        assertNotEquals(5, driver.getRating());
    }

    @Test
    public void testToString() {
        String expected = "Driver{" +
                "id=" + driver.getId() +
                ", name='" + driver.getName() + '\'' +
                ", typeOfPayment='" + driver.getTypeOfPayment() + '\'' +
                ", totalEarned=" + driver.getTotalEarned() +
                ", totalRides=" + driver.getTotalRides() +
                ", numberPlate='" + driver.getNumberPlate() + '\'' +
                ", numberOfPassengers=" + driver.getNumberOfPassengers() +
                ", segment='" + driver.getSegment() + '\'' +
                ", rating=" + driver.getRating() +
                '}';
        assertEquals(expected, driver.toString());
    }

}
