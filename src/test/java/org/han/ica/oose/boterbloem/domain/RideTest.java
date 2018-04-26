package org.han.ica.oose.boterbloem.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RideTest {
//    private int id;
//    private int clientId;
//    private int driverId;
//    private int preferedCareInstitution;
//    private int preferedDriver;
//    private Date pickUpDateTime;

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
        field.set(testUser, "asdwefg");

        //when
        final String result = testUser.getPasswordSalt();

        //then
        assertEquals("field wasn't retrieved properly", "asdwefg", result);
    }
}
