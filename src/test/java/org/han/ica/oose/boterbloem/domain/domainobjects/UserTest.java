package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.sql.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserTest {

    @Test
    public void testSetterAddress() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        Address address = new Address();
        user.setAddress(address);

        final Field field = user.getClass().getDeclaredField("address");
        field.setAccessible(true);

        assertEquals("Fields didn't match", address, field.get(user));
    }

    @Test
    public void testGetterAddress() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        Address address = new Address();
        final Field field = user.getClass().getDeclaredField("address");
        field.setAccessible(true);
        field.set(user, address);

        final Address result = user.getAddress();

        assertEquals("Field wasn't retrieved properly", address, result);
    }

    @Test
    public void testSetterFirstName() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        user.setFirstName("Jan");

        final Field field = user.getClass().getDeclaredField("firstName");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Jan", field.get(user));
    }

    @Test
    public void testGetterFirstName() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(user, "Jan");

        final String result = user.getFirstName();

        assertEquals("Field wasn't retrieved properly", "Jan", result);
    }

    @Test
    public void testSetterLastName() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        user.setLastName("de Man");

        final Field field = user.getClass().getDeclaredField("lastName");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "de Man", field.get(user));
    }

    @Test
    public void testGetterLastName() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(user, "de Man");

        final String result = user.getLastName();

        assertEquals("Field wasn't retrieved properly", "de Man", result);
    }

    @Test
    public void testSetterEmail() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        user.setEmail("Jan@deMan.nl");

        final Field field = user.getClass().getDeclaredField("email");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Jan@deMan.nl", field.get(user));
    }

    @Test
    public void testGetterEmail() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("email");
        field.setAccessible(true);
        field.set(user, "Jan@deMan.nl");

        final String result = user.getEmail();

        assertEquals("Field wasn't retrieved properly", "Jan@deMan.nl", result);
    }

    @Test
    public void testSetterPhoneNumber() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        user.setPhoneNumber("06-12345678");

        final Field field = user.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "06-12345678", field.get(user));
    }

    @Test
    public void testGetterPhoneNumber() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        field.set(user, "06-12345678");

        final String result = user.getPhoneNumber();

        assertEquals("Field wasn't retrieved properly", "06-12345678", result);
    }

    @Test
    public void testSetterPassword() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        user.setPassword("wachtwoord");

        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "wachtwoord", field.get(user));
    }

    @Test
    public void testGetterPassword() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(user, "wachtwoord");

        final String result = user.getPassword();

        assertEquals("Field wasn't retrieved properly", "wachtwoord", result);
    }

    @Test
    public void testSetterDateOfBirth() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        Date date = new Date(System.currentTimeMillis());
        user.setDateOfBirth(date);

        final Field field = user.getClass().getDeclaredField("dateOfBirth");
        field.setAccessible(true);

        assertEquals("Fields didn't match", date, field.get(user));
    }

    @Test
    public void testGetterDateOfBirth() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("dateOfBirth");
        field.setAccessible(true);
        Date date = new Date(System.currentTimeMillis());
        field.set(user, date);

        final Date result = user.getDateOfBirth();

        assertEquals("Field wasn't retrieved properly", date, result);
    }

    @Test
    public void testSetterFirstTimeProfileCheck() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        user.setFirstTimeProfileCheck((byte)1);

        final Field field = user.getClass().getDeclaredField("firstTimeProfileCheck");
        field.setAccessible(true);

        assertEquals("Fields didn't match", (byte)1, field.get(user));
    }

    @Test
    public void testGetterFirstTimeProfileCheck() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("firstTimeProfileCheck");
        field.setAccessible(true);
        field.set(user, (byte)1);

        final byte result = user.getFirstTimeProfileCheck();

        assertEquals("Field wasn't retrieved properly", (byte)1, result);
    }
}