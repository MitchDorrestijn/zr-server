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
public class CareInstitutionTest {

    @Test
    public void testSetterAddress() throws NoSuchFieldException, IllegalAccessException {
        final CareInstitution careInstitution = new CareInstitution();
        List<Address> addresses = new ArrayList<>();
        careInstitution.setAddresses(addresses);

        final Field field = careInstitution.getClass().getDeclaredField("addresses");
        field.setAccessible(true);

        assertEquals("Fields didn't match", addresses, field.get(careInstitution));
    }

    @Test
    public void testGetterStreet() throws NoSuchFieldException, IllegalAccessException {
        final CareInstitution careInstitution = new CareInstitution();
        final Field field = careInstitution.getClass().getDeclaredField("addresses");
        field.setAccessible(true);
        List<Address> addresses = new ArrayList<>();
        field.set(careInstitution, addresses);

        final List<Address> result = careInstitution.getAddresses();

        assertEquals("Field wasn't retrieved properly", addresses, result);
    }

    @Test
    public void testSetterName() throws NoSuchFieldException, IllegalAccessException {
        final CareInstitution careInstitution = new CareInstitution();
        careInstitution.setName("Reinaerde");

        final Field field = careInstitution.getClass().getDeclaredField("name");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Reinaerde", field.get(careInstitution));
    }

    @Test
    public void testGetterName() throws NoSuchFieldException, IllegalAccessException {
        final CareInstitution careInstitution = new CareInstitution();
        final Field field = careInstitution.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(careInstitution, "Reinaerde");

        final String result = careInstitution.getName();

        assertEquals("Field wasn't retrieved properly", "Reinaerde", result);
    }

    @Test
    public void testSetterId() throws NoSuchFieldException, IllegalAccessException {
        final CareInstitution careInstitution = new CareInstitution();
        careInstitution.setId(1);

        final Field field = careInstitution.getClass().getDeclaredField("id");
        field.setAccessible(true);

        assertEquals("Fields didn't match", 1, field.get(careInstitution));
    }

    @Test
    public void testGetterId() throws NoSuchFieldException, IllegalAccessException {
        final CareInstitution careInstitution = new CareInstitution();
        final Field field = careInstitution.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(careInstitution, 1);

        final int result = careInstitution.getId();

        assertEquals("Field wasn't retrieved properly", 1, result);
    }
}