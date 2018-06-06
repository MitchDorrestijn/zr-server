package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationTest {

    @Test
    public void testSetterLocation() throws NoSuchFieldException, IllegalAccessException {
        final Location location = new Location();
        location.setLocation("EenLocation");

        final Field field = location.getClass().getDeclaredField("rideLocation");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "EenLocation", field.get(location));
    }

    @Test
    public void testGetterLocation() throws NoSuchFieldException, IllegalAccessException {
        final Location location = new Location();
        final Field field = location.getClass().getDeclaredField("rideLocation");
        field.setAccessible(true);
        field.set(location, "NogEenLocation");

        final String result = location.getLocation();

        assertEquals("Field not retrieved properly", "NogEenLocation", result);
    }
}