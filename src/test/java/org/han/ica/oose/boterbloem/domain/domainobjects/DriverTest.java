package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class DriverTest extends UserTest {

    @Test
    public void testSetterId() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        driver.setId(1);

        final Field field = driver.getClass().getDeclaredField("id");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 1, field.get(driver));
    }

    @Test
    public void testGetterId() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        final Field field = driver.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(driver, 1);

        final int result = driver.getId();

        assertEquals("Field not retrieved properly", 1, result);
    }

    @Test
    public void testSetterVerification() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        driver.setVerification((byte)1);

        final Field field = driver.getClass().getDeclaredField("verification");
        field.setAccessible(true);

        assertEquals("Fields didn't match", (byte)1, field.get(driver));
    }

    @Test
    public void testGetterVerification() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        final Field field = driver.getClass().getDeclaredField("verification");
        field.setAccessible(true);
        field.set(driver, (byte)1);

        final byte result = driver.getVerification();

        assertEquals("Field not retrieved properly", (byte)1, result);
    }

    @Test
    public void testSetterTypeOfPayment() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        driver.setTypeOfPayment("Paypal");

        final Field field = driver.getClass().getDeclaredField("typeOfPayment");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Paypal", field.get(driver));
    }

    @Test
    public void testGetterTypeOfPayment() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        final Field field = driver.getClass().getDeclaredField("typeOfPayment");
        field.setAccessible(true);
        field.set(driver, "iDeal");

        final String result = driver.getTypeOfPayment();

        assertEquals("Field not retrieved properly", "iDeal", result);
    }

    @Test
    public void testSetterImage() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        driver.setImage("imgur.com/afbeelding");

        final Field field = driver.getClass().getDeclaredField("image");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "imgur.com/afbeelding", field.get(driver));
    }

    @Test
    public void testGetterImage() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        final Field field = driver.getClass().getDeclaredField("image");
        field.setAccessible(true);
        field.set(driver, "imgur.com/nogEenAfbeelding");

        final String result = driver.getImage();

        assertEquals("Field not retrieved properly", "imgur.com/nogEenAfbeelding", result);
    }

    @Test
    public void testSetterAccountNr() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        driver.setAccountnr("EenAccountNr");

        final Field field = driver.getClass().getDeclaredField("accountnr");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "EenAccountNr", field.get(driver));
    }

    @Test
    public void testGetterAccountNr() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        final Field field = driver.getClass().getDeclaredField("accountnr");
        field.setAccessible(true);
        field.set(driver, "NogEenAccountNr");

        final String result = driver.getAccountnr();

        assertEquals("Field not retrieved properly", "NogEenAccountNr", result);
    }

    @Test
    public void testSetterDriverCars() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        List<DriverCar> driverCars = new ArrayList<>();
        driver.setDriverCars(driverCars);

        final Field field = driver.getClass().getDeclaredField("driverCars");
        field.setAccessible(true);

        assertEquals("Fields didn't match", driverCars, field.get(driver));
    }

    @Test
    public void testGetterDriverCars() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        final Field field = driver.getClass().getDeclaredField("driverCars");
        field.setAccessible(true);
        List<DriverCar> driverCars = new ArrayList<>();
        field.set(driver, driverCars);

        final List<DriverCar> result = driver.getDriverCars();

        assertEquals("Field not retrieved properly", driverCars, result);
    }

    @Test
    public void testSetterTotalEarned() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        driver.setTotalEarned(100.00f);

        final Field field = driver.getClass().getDeclaredField("totalEarned");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 100.00f, field.get(driver));
    }

    @Test
    public void testGetterTotalEarned() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        final Field field = driver.getClass().getDeclaredField("totalEarned");
        field.setAccessible(true);
        field.set(driver, 531.00f);

        final float result = driver.getTotalEarned();

        assertEquals("Field not retrieved properly", 531f, result, 0.00);
    }

    @Test
    public void testSetterTotalRides() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        driver.setTotalRides(10);

        final Field field = driver.getClass().getDeclaredField("totalRides");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 10, field.get(driver));
    }

    @Test
    public void testGetterTotalRides() throws NoSuchFieldException, IllegalAccessException {
        final Driver driver = new Driver();
        final Field field = driver.getClass().getDeclaredField("totalRides");
        field.setAccessible(true);
        field.set(driver, 12);

        final int result = driver.getTotalRides();

        assertEquals("Field not retrieved properly", 12, result);
    }
}