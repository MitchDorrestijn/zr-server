package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UtilityTest {

    @Test
    public void testSetterDriverName() throws NoSuchFieldException, IllegalAccessException {
        final Utility utility = new Utility();
        utility.setUtility("Wandelstok");

        final Field field = utility.getClass().getDeclaredField("utilityName");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "Wandelstok", field.get(utility));
    }

    @Test
    public void testGetterLimitation() throws NoSuchFieldException, IllegalAccessException {
        final Utility utility = new Utility();
        final Field field = utility.getClass().getDeclaredField("utilityName");
        field.setAccessible(true);
        field.set(utility, "NogEenWandelstok");

        final String result = utility.getUtility();

        assertEquals("Field not retrieved properly", "NogEenWandelstok", result);
    }
}