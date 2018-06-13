package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testSetterWarningPkb() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        client.setWarningPKB(true);

        final Field field = client.getClass().getDeclaredField("warningPkb");
        field.setAccessible(true);

        assertEquals("Fields didn't match", true, field.get(client));
    }

    @Test
    public void testGetterWarningPkb() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("warningPkb");
        field.setAccessible(true);
        field.set(client, false);

        final boolean result = client.getWarningPkb();

        assertEquals("Field not retrieved properly", false, result);
    }

    @Test
    public void testSetterPkb() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        client.setPkb(345);

        final Field field = client.getClass().getDeclaredField("pkb");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 345, field.get(client));
    }

    @Test
    public void testGetterPkb() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("pkb");
        field.setAccessible(true);
        field.set(client, 345);

        final int result = client.getPkb();

        assertEquals("Field not retrieved properly", 345, result);
    }

    @Test
    public void testSetterCompanionRequired() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        client.setCompanionRequired((byte) 1);

        final Field field = client.getClass().getDeclaredField("companionRequired");
        field.setAccessible(true);

        assertEquals("Fields didn't match", (byte) 1, field.get(client));
    }

    @Test
    public void testGetterCompanionRequired() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("companionRequired");
        field.setAccessible(true);
        field.set(client, (byte) 1);

        final byte result = client.getCompanionRequired();

        assertEquals("Field not retrieved properly", (byte) 1, result);
    }

    @Test
    public void testSetterImage() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        client.setImage("imgur.com/afbeelding");

        final Field field = client.getClass().getDeclaredField("image");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "imgur.com/afbeelding", field.get(client));
    }

    @Test
    public void testGetterImage() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("image");
        field.setAccessible(true);
        field.set(client, "imgur.com/nogEenAfbeelding");

        final String result = client.getImage();

        assertEquals("Field not retrieved properly", "imgur.com/nogEenAfbeelding", result);
    }

    @Test
    public void testSetterBankAccount() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        client.setBankAccount("SomeBankAccount");

        final Field field = client.getClass().getDeclaredField("bankAccount");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "SomeBankAccount", field.get(client));
    }

    @Test
    public void testGetterBankAccount() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("bankAccount");
        field.setAccessible(true);
        field.set(client, "EenBankAccount");

        final String result = client.getBankAccount();

        assertEquals("Field not retrieved properly", "EenBankAccount", result);
    }

    @Test
    public void testSetterLimitations() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        List<Limitation> limitations = new ArrayList<>();
        client.setLimitations(limitations);

        final Field field = client.getClass().getDeclaredField("limitations");
        field.setAccessible(true);

        assertEquals("Fields didn't match", limitations, field.get(client));
    }

    @Test
    public void testGetterLimitations() throws NoSuchFieldException, IllegalAccessException {
        final Client client = new Client();
        final Field field = client.getClass().getDeclaredField("limitations");
        field.setAccessible(true);
        List<Limitation> limitations = new ArrayList<>();
        field.set(client, limitations);

        final List<Limitation> result = client.getLimitations();

        assertEquals("Field not retrieved properly", limitations, result);
    }

    @Test
    public void testAdderLimitations() {
        final Client client = new Client();
        Limitation limitation = new Limitation();
        client.addLimitation(limitation);

        assertEquals(limitation, client.getLimitations().get(client.getLimitations().size() - 1));
    }
}