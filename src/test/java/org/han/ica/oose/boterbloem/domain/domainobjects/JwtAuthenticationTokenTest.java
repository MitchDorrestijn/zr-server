package org.han.ica.oose.boterbloem.domain.domainobjects;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
public class JwtAuthenticationTokenTest {
    @Test
    public void testSetterLimitation() throws NoSuchFieldException, IllegalAccessException {
        final JwtAuthenticationToken token = new JwtAuthenticationToken("token");
        token.setToken("token");

        final Field field = token.getClass().getDeclaredField("token");
        field.setAccessible(true);

        assertEquals("Fields didn't match", "token", field.get(token));
    }

    @Test
    public void testGetterLimitation() throws NoSuchFieldException, IllegalAccessException {
        final JwtAuthenticationToken token = new JwtAuthenticationToken("token");
        final Field field = token.getClass().getDeclaredField("token");
        field.setAccessible(true);
        field.set(token, "token");

        final String result = token.getToken();

        assertEquals("Field not retrieved properly", "token", result);
    }

    @Test
    public void testObject(){
        final JwtAuthenticationToken token = new JwtAuthenticationToken("token");
        assertNull(token.getCredentials());
        assertNull(token.getPrincipal());
    }

}
