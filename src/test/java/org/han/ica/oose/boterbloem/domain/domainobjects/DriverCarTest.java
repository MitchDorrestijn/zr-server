package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class DriverCarTest {

    @Test
    public void testSetterUtility() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        driverCar.setUtility("EenUtility");

        final Field field = driverCar.getClass().getDeclaredField("utility");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "EenUtility", field.get(driverCar));
    }

    @Test
    public void testGetterUtility() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        final Field field = driverCar.getClass().getDeclaredField("utility");
        field.setAccessible(true);
        field.set(driverCar, "NogEenUtility");

        final String result = driverCar.getUtility();

        assertEquals("Field not retrieved properly", "NogEenUtility", result);
    }

    @Test
    public void testSetterNumberPlate() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        driverCar.setNumberPlate("1-ABC-23");

        final Field field = driverCar.getClass().getDeclaredField("numberPlate");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "1-ABC-23", field.get(driverCar));
    }

    @Test
    public void testGetterNumberPlate() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        final Field field = driverCar.getClass().getDeclaredField("numberPlate");
        field.setAccessible(true);
        field.set(driverCar, "45-DEF-6");

        final String result = driverCar.getNumberPlate();

        assertEquals("Field not retrieved properly", "45-DEF-6", result);
    }

    @Test
    public void testSetterNumberOfPassengers() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        driverCar.setNumberOfPassengers(5);

        final Field field = driverCar.getClass().getDeclaredField("numberOfPassengers");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 5, field.get(driverCar));
    }

    @Test
    public void testGetterNumberOfPassengers() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        final Field field = driverCar.getClass().getDeclaredField("numberOfPassengers");
        field.setAccessible(true);
        field.set(driverCar, 5);

        final int result = driverCar.getNumberOfPassengers();

        assertEquals("Field not retrieved properly", 5, result);
    }

    @Test
    public void testSetterSegment() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        driverCar.setSegment("A");

        final Field field = driverCar.getClass().getDeclaredField("segment");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "A", field.get(driverCar));
    }

    @Test
    public void testGetterSegment() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        final Field field = driverCar.getClass().getDeclaredField("segment");
        field.setAccessible(true);
        field.set(driverCar, "B");

        final String result = driverCar.getSegment();

        assertEquals("Field not retrieved properly", "B", result);
    }

    @Test
    public void testSetterBrand() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        driverCar.setBrand("Volvo");

        final Field field = driverCar.getClass().getDeclaredField("brand");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Volvo", field.get(driverCar));
    }

    @Test
    public void testGetterBrand() throws NoSuchFieldException, IllegalAccessException {
        final DriverCar driverCar = new DriverCar();
        final Field field = driverCar.getClass().getDeclaredField("brand");
        field.setAccessible(true);
        field.set(driverCar, "Chrysler");

        final String result = driverCar.getBrand();

        assertEquals("Field not retrieved properly", "Chrysler", result);
    }
}