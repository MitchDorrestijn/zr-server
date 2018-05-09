package org.han.ica.oose.boterbloem.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientDriverPreferenceTest {

    @Test
    public void testGetter_getsDriverId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final ClientDriverPreference clientDriverPreference = new ClientDriverPreference();
        final Field field = clientDriverPreference.getClass().getDeclaredField("driverId");
        field.setAccessible(true);
        field.set(clientDriverPreference, 1);

        //when
        final int result = clientDriverPreference.getDriverId();

        //then
        assertEquals("field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetter_setsDriverId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final ClientDriverPreference clientDriverPreference = new ClientDriverPreference();

        clientDriverPreference.setDriverId(1);
        //when
        final Field field = clientDriverPreference.getClass().getDeclaredField("driverId");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 1, field.get(clientDriverPreference));

    }

    @Test
    public void testGetter_getsClientId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final ClientDriverPreference clientDriverPreference = new ClientDriverPreference();

        final Field field = clientDriverPreference.getClass().getDeclaredField("clientId");
        field.setAccessible(true);
        field.set(clientDriverPreference, 1);

        //when
        final int result = clientDriverPreference.getClientId();

        //then
        assertEquals("field wasn't retrieved properly", 1, result);
    }

    @Test
    public void testSetter_setsClientId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final ClientDriverPreference clientDriverPreference = new ClientDriverPreference();

        clientDriverPreference.setClientId(1);
        //when
        final Field field = clientDriverPreference.getClass().getDeclaredField("clientId");
        field.setAccessible(true);

        //then
        assertEquals("Fields didn't match", 1, field.get(clientDriverPreference));

    }
}
