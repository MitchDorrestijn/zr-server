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
}
