package org.han.ica.oose.boterbloem.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {


    @Test
    public void testSetter_setsClientId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Client client = new Client();

        client.setClientId(1);
        //when
        final Field field = client.getClass().getDeclaredField("clientId");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 1, field.get(client));

    }

    @Test
    public void testGetter_getsClientId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("clientId");
        field.setAccessible(true);
        field.set(client, 1);

        //when
        final int result = client.getClientId();

        //then
        assertEquals("field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetter_setsCompanion() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Client client = new Client();

        client.setCompanion("Martijn");
        //when
        final Field field = client.getClass().getDeclaredField("companion");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", "Martijn", field.get(client));

    }

    @Test
    public void testGetter_getsCompanion() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("companion");
        field.setAccessible(true);
        field.set(client, "Martijn");

        //when
        final String result = client.getCompanion();

        //then
        assertEquals("field wasn't retrieved properly", "Martijn", result);
    }

    @Test
    public void testSetter_setsUtility() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Client client = new Client();

        client.setUtility("Some stuff");
        //when
        final Field field = client.getClass().getDeclaredField("utility");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", "Some stuff", field.get(client));

    }

    @Test
    public void testGetter_getsUtility() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("utility");
        field.setAccessible(true);
        field.set(client, "Some stuff");

        //when
        final String result = client.getUtility();

        //then
        assertEquals("field wasn't retrieved properly", "Some stuff", result);
    }

    @Test
    public void testSetter_setsdriverPreferenceForced() throws NoSuchFieldException, IllegalAccessException {

        //given
        final Client client = new Client();

        client.setDriverPreferenceF(true);
        //when
        final Field field = client.getClass().getDeclaredField("driverPreferenceForced");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", true, field.get(client));

    }

    @Test
    public void testGetter_getsdriverPreferenceForced() throws NoSuchFieldException, IllegalAccessException {

        //given
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("driverPreferenceForced");
        field.setAccessible(true);
        field.set(client, true);

        //when
        final Boolean result = client.isDriverPreferenceF();

        //then
        assertEquals("field wasn't retrieved properly", true, result);
    }
}
