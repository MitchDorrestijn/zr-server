package org.han.ica.oose.boterbloem.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RideTest {

    @Test
    public void testSetter_setsRideId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setId(1);
        //when
        final Field field = testRide.getClass().getDeclaredField("id");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 1, field.get(testRide));

    }

    @Test
    public void testGetter_getsRideId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();
        final Field field = testRide.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(testRide, 1);

        //when
        final int result = testRide.getId();

        //then
        assertEquals("field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetter_setsDriverId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setDriverId(1);
        //when
        final Field field = testRide.getClass().getDeclaredField("driverId");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 1, field.get(testRide));

    }

    @Test
    public void testGetter_getsDriverId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();
        final Field field = testRide.getClass().getDeclaredField("driverId");
        field.setAccessible(true);
        field.set(testRide, 1);

        //when
        final int result = testRide.getDriverId();

        //then
        assertEquals("field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetter_setsClientId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setClientId(1);
        //when
        final Field field = testRide.getClass().getDeclaredField("clientId");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 1, field.get(testRide));

    }

    @Test
    public void testGetter_getsClientId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();
        final Field field = testRide.getClass().getDeclaredField("clientId");
        field.setAccessible(true);
        field.set(testRide, 1);

        //when
        final int result = testRide.getClientId();

        //then
        assertEquals("field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetter_setsPreferedCareInstitution() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setPreferedCareInstitution(1);
        //when
        final Field field = testRide.getClass().getDeclaredField("preferedCareInstitution");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 1, field.get(testRide));

    }

    @Test
    public void testGetter_getsPreferedCareInstitution() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();
        final Field field = testRide.getClass().getDeclaredField("preferedCareInstitution");
        field.setAccessible(true);
        field.set(testRide, 1);

        //when
        final int result = testRide.getPreferedCareInstitution();

        //then
        assertEquals("field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetter_setsPreferedDriver() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setPreferedDriver(1);
        //when
        final Field field = testRide.getClass().getDeclaredField("preferedDriver");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 1, field.get(testRide));

    }

    @Test
    public void testGetter_getsPreferedDriver() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();
        final Field field = testRide.getClass().getDeclaredField("preferedDriver");
        field.setAccessible(true);
        field.set(testRide, 1);

        //when
        final int result = testRide.getPreferedDriver();

        //then
        assertEquals("field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetter_setsPickupDate() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();
        final Date date = new Date(2018, 4, 26);

        testRide.setPickUpDateTime(date);
        //when
        final Field field = testRide.getClass().getDeclaredField("pickUpDateTime");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", field.get(testRide), date);

    }

    @Test
    public void testGetter_getsPickupDate() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();
        final Date date = new Date(2018, 4, 26);
        final Field field = testRide.getClass().getDeclaredField("pickUpDateTime");
        field.setAccessible(true);
        field.set(testRide, date);

        //when
        final Date result = testRide.getPickUpDateTime();

        //then
        assertEquals("field wasn't retrieved properly", result, date);
    }

    @Test
    public void testSetter_setsDropOffLocation() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setDropOffLocation("Location");
        //when
        final Field field = testRide.getClass().getDeclaredField("dropOffLocation");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", "Location", field.get(testRide));

    }

    @Test
    public void testGetter_getsDropOffLocation() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("dropOffLocation");
        field.setAccessible(true);
        field.set(testRide, "Location");

        //when
        final String result = testRide.getDropOffLocation();

        //then
        assertEquals("field wasn't retrieved properly", "Location", result);
    }

    @Test
    public void testSetter_setsDuration() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setDuration(5);
        //when
        final Field field = testRide.getClass().getDeclaredField("duration");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 5, field.get(testRide));

    }

    @Test
    public void testGetter_getsDuration() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("duration");
        field.setAccessible(true);
        field.set(testRide, 5);

        //when
        final int result = testRide.getDuration();

        //then
        assertEquals("field wasn't retrieved properly", 5, result);
    }

    @Test
    public void testSetter_setsDistance() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setDistance(5);
        //when
        final Field field = testRide.getClass().getDeclaredField("distance");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 5, field.get(testRide));

    }

    @Test
    public void testGetter_getsDistance() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("distance");
        field.setAccessible(true);
        field.set(testRide, 5);

        //when
        final int result = testRide.getDistance();

        //then
        assertEquals("field wasn't retrieved properly", 5, result);
    }

    @Test
    public void testSetter_setsNumberOfCompanions() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setNumerOfCompanions(5);
        //when
        final Field field = testRide.getClass().getDeclaredField("numberOfCompanions");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 5, field.get(testRide));

    }

    @Test
    public void testGetter_getsNumberOfCompanions() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("numberOfCompanions");
        field.setAccessible(true);
        field.set(testRide, 5);

        //when
        final int result = testRide.getNumerOfCompanions();

        //then
        assertEquals("field wasn't retrieved properly", 5, result);
    }

    @Test
    public void testSetter_setsNumberOfLuggage() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setNumerOfLuggage(5);
        //when
        final Field field = testRide.getClass().getDeclaredField("numberOfLuggage");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 5, field.get(testRide));

    }

    @Test
    public void testGetter_getsNumberOfLuggage() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("numberOfLuggage");
        field.setAccessible(true);
        field.set(testRide, 5);

        //when
        final int result = testRide.getNumerOfLuggage();

        //then
        assertEquals("field wasn't retrieved properly", 5, result);
    }

    @Test
    public void testSetter_setsReturnRide() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setReturnRide(true);
        //when
        final Field field = testRide.getClass().getDeclaredField("returnRide");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", true, field.get(testRide));

    }

    @Test
    public void testGetter_getsReturnRide() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("returnRide");
        field.setAccessible(true);
        field.set(testRide, true);

        //when
        final boolean result = testRide.isReturnRide();

        //then
        assertEquals("field wasn't retrieved properly", true, result);
    }

    @Test
    public void testSetter_setsCallService() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setCallService(true);
        //when
        final Field field = testRide.getClass().getDeclaredField("callService");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", true, field.get(testRide));

    }

    @Test
    public void testGetter_getsCallService() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("callService");
        field.setAccessible(true);
        field.set(testRide, true);

        //when
        final boolean result = testRide.isCallService();

        //then
        assertEquals("field wasn't retrieved properly", true, result);
    }

    @Test
    public void testSetter_setsUtility() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setUtility("Something");
        //when
        final Field field = testRide.getClass().getDeclaredField("utility");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", "Something", field.get(testRide));

    }

    @Test
    public void testGetter_getsUtility() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("utility");
        field.setAccessible(true);
        field.set(testRide, "Something");

        //when
        final String result = testRide.getUtility();

        //then
        assertEquals("field wasn't retrieved properly", "Something", result);
    }

    @Test
    public void testSetter_setsRepeatingRideId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setRepeatingRideId(5);
        //when
        final Field field = testRide.getClass().getDeclaredField("repeatingRideId");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 5, field.get(testRide));

    }

    @Test
    public void testGetter_getsRepeatingRideId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("repeatingRideId");
        field.setAccessible(true);
        field.set(testRide, 5);

        //when
        final int result = testRide.getRepeatingRideId();

        //then
        assertEquals("field wasn't retrieved properly", 5, result);
    }

    @Test
    public void testSetter_setsCancelledByClient() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setCancelledByClient(true);
        //when
        final Field field = testRide.getClass().getDeclaredField("cancelledByClient");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", true, field.get(testRide));

    }

    @Test
    public void testGetter_getsCancelledByClient() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("cancelledByClient");
        field.setAccessible(true);
        field.set(testRide, true);

        //when
        final boolean result = testRide.isCancelledByClient();

        //then
        assertEquals("field wasn't retrieved properly", true, result);
    }
    @Test
    public void testSetter_setsExecuted() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        testRide.setExecuted(true);
        //when
        final Field field = testRide.getClass().getDeclaredField("executed");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", true, field.get(testRide));

    }

    @Test
    public void testGetter_getsExecuted() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Ride testRide = new Ride();

        final Field field = testRide.getClass().getDeclaredField("executed");
        field.setAccessible(true);
        field.set(testRide, true);

        //when
        final boolean result = testRide.isExecuted();

        //then
        assertEquals("field wasn't retrieved properly", true, result);
    }

}
