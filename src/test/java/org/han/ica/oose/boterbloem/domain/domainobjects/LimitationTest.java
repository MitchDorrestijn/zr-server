package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LimitationTest {
    @Test
    public void testSetterLimitation() throws NoSuchFieldException, IllegalAccessException {
        final Limitation limitation = new Limitation();
        limitation.setLimitation("EenLimitation");

        final Field field = limitation.getClass().getDeclaredField("limitation");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "EenLimitation", field.get(limitation));
    }

    @Test
    public void testGetterLimitation() throws NoSuchFieldException, IllegalAccessException {
        final Limitation limitation = new Limitation();
        final Field field = limitation.getClass().getDeclaredField("limitation");
        field.setAccessible(true);
        field.set(limitation, "NogEenLimitation");

        final String result = limitation.getLimitation();

        assertEquals("Field not retrieved properly", "NogEenLimitation", result);
    }
}