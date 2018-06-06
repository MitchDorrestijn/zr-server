package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingsTest {

    @Test
    public void testSetterDriverName() throws NoSuchFieldException, IllegalAccessException {
        final Rating rating = new Rating();
        rating.setDriverName("Bestuurder");

        final Field field = rating.getClass().getDeclaredField("driverName");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Bestuurder", field.get(rating));
    }

    @Test
    public void testGetterLimitation() throws NoSuchFieldException, IllegalAccessException {
        final Rating rating = new Rating();
        final Field field = rating.getClass().getDeclaredField("driverName");
        field.setAccessible(true);
        field.set(rating, "NogEenBestuurder");

        final String result = rating.getDriverName();

        assertEquals("Field not retrieved properly", "NogEenBestuurder", result);
    }

    @Test
    public void testSetterStars() throws NoSuchFieldException, IllegalAccessException {
        final Rating rating = new Rating();
        rating.setStars(5);

        final Field field = rating.getClass().getDeclaredField("stars");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 5, field.get(rating));
    }

    @Test
    public void testGetterStars() throws NoSuchFieldException, IllegalAccessException {
        final Rating rating = new Rating();
        final Field field = rating.getClass().getDeclaredField("stars");
        field.setAccessible(true);
        field.set(rating, 4);

        final int result = rating.getStars();

        assertEquals("Field not retrieved properly", 4, result);
    }

    @Test
    public void testSetterComment() throws NoSuchFieldException, IllegalAccessException {
        final Rating rating = new Rating();
        rating.setComment("EenOpmerking");

        final Field field = rating.getClass().getDeclaredField("comment");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "EenOpmerking", field.get(rating));
    }

    @Test
    public void testGetterComment() throws NoSuchFieldException, IllegalAccessException {
        final Rating rating = new Rating();
        final Field field = rating.getClass().getDeclaredField("comment");
        field.setAccessible(true);
        field.set(rating, "NogEenOpmerking");

        final String result = rating.getComment();

        assertEquals("Field not retrieved properly", "NogEenOpmerking", result);
    }

    @Test
    public void testSetterClientName() throws NoSuchFieldException, IllegalAccessException {
        final Rating rating = new Rating();
        rating.setClientName("EenClient");

        final Field field = rating.getClass().getDeclaredField("clientName");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "EenClient", field.get(rating));
    }

    @Test
    public void testGetterClientName() throws NoSuchFieldException, IllegalAccessException {
        final Rating rating = new Rating();
        final Field field = rating.getClass().getDeclaredField("clientName");
        field.setAccessible(true);
        field.set(rating, "NogEenClient");

        final String result = rating.getClientName();

        assertEquals("Field not retrieved properly", "NogEenClient", result);
    }
}