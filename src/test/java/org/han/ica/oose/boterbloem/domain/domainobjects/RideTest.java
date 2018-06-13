package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class RideTest {

    @Test
    public void testSetterPickUpDateTime() throws IllegalAccessException, NoSuchFieldException {
        final Ride ride = new Ride();
        final Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        ride.setPickUpDateTime(timeStamp);

        final Field field = ride.getClass().getDeclaredField("pickUpDateTime");
        field.setAccessible(true);

        assertEquals("Fields didn't match", timeStamp, field.get(ride));
    }

    @Test
    public void testGetterPickUpDateTime() throws IllegalAccessException, NoSuchFieldException {
        final Ride ride = new Ride();
        final Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        final Field field = ride.getClass().getDeclaredField("pickUpDateTime");
        field.setAccessible(true);
        field.set(ride, timeStamp);

        final Timestamp result = ride.getPickUpDateTime();

        assertEquals("Field wasn't retrieved properly", timeStamp, result);
    }

    @Test
    public void testSetterPickUpLocation() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setPickUpLocation("Ede");

        final Field field = ride.getClass().getDeclaredField("pickUpLocation");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Ede", field.get(ride));
    }

    @Test
    public void testGetterPickUpLocation() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("pickUpLocation");
        field.setAccessible(true);
        field.set(ride, "Ede");

        final String result = ride.getPickUpLocation();

        assertEquals("Field wasn't retrieved properly", "Ede", result);
    }

    @Test
    public void testSetterDropOffLocation() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setDropOffLocation("Ede");

        final Field field = ride.getClass().getDeclaredField("dropOffLocation");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Ede", field.get(ride));
    }

    @Test
    public void testGetterDropOffLocation() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("dropOffLocation");
        field.setAccessible(true);
        field.set(ride, "Ede");

        final String result = ride.getDropOffLocation();

        assertEquals("Field wasn't retrieved properly", "Ede", result);
    }

    @Test
    public void testSetterUtilities() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();

        List<Utility> utilities = new ArrayList<>();
        utilities.add(new Utility());
        ride.setUtilities(utilities);

        final Field field = ride.getClass().getDeclaredField("utilities");
        field.setAccessible(true);

        assertEquals("Fields didn't match", utilities, field.get(ride));
    }

    @Test
    public void testGetterUtilities() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("utilities");
        field.setAccessible(true);
        List<Utility> utilities = new ArrayList<>();
        utilities.add(new Utility());
        field.set(ride, utilities);

        final List<Utility> result = ride.getUtilities();

        assertEquals("Field wasn't retrieved properly", utilities, result);
    }

    @Test
    public void testSetterDriver() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();

        Driver driver = new Driver();
        ride.setDriver(driver);

        final Field field = ride.getClass().getDeclaredField("driver");
        field.setAccessible(true);

        assertEquals("Fields didn't match", driver, field.get(ride));
    }

    @Test
    public void testGetterDriver() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("driver");
        field.setAccessible(true);
        Driver driver = new Driver();
        ride.setDriver(driver);
        field.set(ride, driver);

        final Driver result = ride.getDriver();

        assertEquals("Field wasn't retrieved properly", driver, result);
    }

    @Test
    public void testSetterClient() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();

        Client client = new Client();
        ride.setClient(client);

        final Field field = ride.getClass().getDeclaredField("client");
        field.setAccessible(true);

        assertEquals("Fields didn't match", client, field.get(ride));
    }

    @Test
    public void testGetterClient() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("client");
        field.setAccessible(true);
        Client client = new Client();
        ride.setClient(client);
        field.set(ride, client);

        final Client result = ride.getClient();

        assertEquals("Field wasn't retrieved properly", client, result);
    }

    @Test
    public void testSetterPaymentDescription() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setPaymentDescription("Betalen met PayPal zsm");

        final Field field = ride.getClass().getDeclaredField("paymentDescription");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Betalen met PayPal zsm", field.get(ride));
    }

    @Test
    public void testGetterPaymentDescription() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("paymentDescription");
        field.setAccessible(true);
        field.set(ride, "Betalen met iDeal zsm");

        final String result = ride.getPaymentDescription();

        assertEquals("Field wasn't retrieved properly", "Betalen met iDeal zsm", result);
    }

    @Test
    public void testSetterPaymentStatus() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setPaymentStatus("In afwachting");

        final Field field = ride.getClass().getDeclaredField("paymentStatus");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "In afwachting", field.get(ride));
    }

    @Test
    public void testGetterPaymentStatus() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("paymentStatus");
        field.setAccessible(true);
        field.set(ride, "Betaald");

        final String result = ride.getPaymentStatus();

        assertEquals("Field wasn't retrieved properly", "Betaald", result);
    }

    @Test
    public void testSetterPaymentDueBefore() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        String date = "2018-04-10";
        ride.setPaymentDueBefore(date);

        final Field field = ride.getClass().getDeclaredField("paymentDueBefore");
        field.setAccessible(true);

        assertEquals("Fields didn't match", date, field.get(ride));
    }

    @Test
    public void testGetterPaymentDueBefore() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("paymentDueBefore");
        field.setAccessible(true);
        String date = new Date(System.currentTimeMillis()).toString();

        field.set(ride, date);

        final String result = ride.getPaymentDueBefore();

        assertEquals("Field wasn't retrieved properly", date, result);
    }

    @Test
    public void testSetterPriceOfRide() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setPriceOfRide((float) 50.00);

        final Field field = ride.getClass().getDeclaredField("priceOfRide");
        field.setAccessible(true);

        assertEquals("Fields didn't match", (float)50.00, field.get(ride));
    }

    @Test
    public void testGetterPriceOfRide() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("priceOfRide");
        field.setAccessible(true);
        field.set(ride, (float)50.00);

        final float result = ride.getPriceOfRide();

        assertEquals("Field wasn't retrieved properly", 50.00, result, 0.0);
    }

    @Test
    public void testSetterNumberOfCompanions() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setNumberOfcompanions(1);

        final Field field = ride.getClass().getDeclaredField("numberOfcompanions");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 1, field.get(ride));
    }

    @Test
    public void testGetterNumberOfCompanions() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("numberOfcompanions");
        field.setAccessible(true);
        field.set(ride, 2);

        final int result = ride.getNumberOfcompanions();

        assertEquals("Field wasn't retrieved properly", 2, result);
    }

    @Test
    public void testSetterNumberOfLuggage() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setNumberOfLuggage(5);

        final Field field = ride.getClass().getDeclaredField("numberOfLuggage");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 5, field.get(ride));
    }

    @Test
    public void testGetterNumberOfLuggage() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("numberOfLuggage");
        field.setAccessible(true);
        field.set(ride, 5);

        final int result = ride.getNumberOfLuggage();

        assertEquals("Field wasn't retrieved properly", 5, result);
    }

    @Test
    public void testSetterReturnRide() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setReturnRide((byte) 1);

        final Field field = ride.getClass().getDeclaredField("returnRide");
        field.setAccessible(true);

        assertEquals("Fields didn't match", (byte)1, field.get(ride));
    }

    @Test
    public void testGetterReturnRide() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("returnRide");
        field.setAccessible(true);
        field.set(ride, (byte)1);

        final byte result = ride.isReturnRide();

        assertEquals("Field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetterCallService() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        ride.setCallService((byte) 1);

        final Field field = ride.getClass().getDeclaredField("callService");
        field.setAccessible(true);

        assertEquals("Fields didn't match", (byte)1, field.get(ride));
    }

    @Test
    public void testGetterCallService() throws NoSuchFieldException, IllegalAccessException {
        final Ride ride = new Ride();
        final Field field = ride.getClass().getDeclaredField("callService");
        field.setAccessible(true);
        field.set(ride, (byte)1);

        final byte result = ride.isCallService();

        assertEquals("Field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testAdderUtility() {
        Ride ride = new Ride();
        Utility utility = new Utility();
        utility.setUtility("Wandelstok");
        ride.addUtility(utility);
        assertEquals("Objects didn't match properly", utility, ride.getUtilities().get(ride.getUtilities().size() - 1));
    }
}