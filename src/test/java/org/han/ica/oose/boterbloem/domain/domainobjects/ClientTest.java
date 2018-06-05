package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ClientTest extends UserTest {

    @Test
    public void testSetterId() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        client.setId(1);

        final Field field = client.getClass().getDeclaredField("id");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 1, field.get(client));
    }

    @Test
    public void testGetterId() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(client, 1);

        final int result = client.getId();

        assertEquals("Field not retrieved properly", 1, result);
    }

    @Test
    public void testSetterCompanion() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        client.setCompanion("Bas");

        final Field field = client.getClass().getDeclaredField("companion");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Bas", field.get(client));
    }

    @Test
    public void testGetterCompanion() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("companion");
        field.setAccessible(true);
        field.set(client, "Bas");

        final String result = client.getCompanion();

        assertEquals("Field not retrieved properly", "Bas", result);
    }
}