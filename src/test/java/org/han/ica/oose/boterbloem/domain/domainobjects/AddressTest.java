package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

    @Test
    public void testSetterStreet() throws NoSuchFieldException, IllegalAccessException {
        final Address address = new Address();
        address.setStreet("Ruitenberglaan");

        final Field field = address.getClass().getDeclaredField("street");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Ruitenberglaan", field.get(address));
    }

    @Test
    public void testGetterStreet() throws NoSuchFieldException, IllegalAccessException {
        final Address address = new Address();
        final Field field = address.getClass().getDeclaredField("street");
        field.setAccessible(true);
        field.set(address, "Hoefweg");

        final String result = address.getStreet();

        assertEquals("Field wasn't retrieved properly", "Hoefweg", result);
    }

    @Test
    public void testSetterHouseNumber() throws NoSuchFieldException, IllegalAccessException {
        final Address address = new Address();
        address.setHouseNumber("45-B");

        final Field field = address.getClass().getDeclaredField("houseNumber");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "45-B", field.get(address));
    }

    @Test
    public void testGetterHouseNumber() throws NoSuchFieldException, IllegalAccessException {
        final Address address = new Address();
        final Field field = address.getClass().getDeclaredField("houseNumber");
        field.setAccessible(true);
        field.set(address, "45-C");

        final String result = address.getHouseNumber();

        assertEquals("Field wasn't retrieved properly", "45-C", result);
    }

    @Test
    public void testSetterZipCode() throws NoSuchFieldException, IllegalAccessException {
        final Address address = new Address();
        address.setZipCode("4567DE");

        final Field field = address.getClass().getDeclaredField("zipCode");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "4567DE", field.get(address));
    }

    @Test
    public void testGetterZipCode() throws NoSuchFieldException, IllegalAccessException {
        final Address address = new Address();
        final Field field = address.getClass().getDeclaredField("zipCode");
        field.setAccessible(true);
        field.set(address, "1234AB");

        final String result = address.getZipCode();

        assertEquals("Field wasn't retrieved properly", "1234AB", result);
    }

    @Test
    public void testSetterResidence() throws NoSuchFieldException, IllegalAccessException {
        final Address address = new Address();
        address.setResidence("Arnhem");

        final Field field = address.getClass().getDeclaredField("residence");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Arnhem", field.get(address));
    }

    @Test
    public void testGetterResidence() throws NoSuchFieldException, IllegalAccessException {
        final Address address = new Address();
        final Field field = address.getClass().getDeclaredField("residence");
        field.setAccessible(true);
        field.set(address, "Arnhem");

        final String result = address.getResidence();

        assertEquals("Field wasn't retrieved properly", "Arnhem", result);
    }
}