package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.security.JwtGenerator;
import org.han.ica.oose.boterbloem.security.SecurityProperties;
import org.han.ica.oose.boterbloem.service.IAuthService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.AuthService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class TokenControllerTest extends JpaTestConfig {
    JwtUser jwtUser = new JwtUser();
    JwtGenerator jwtGenerator = new JwtGenerator();
    TokenController tokenController;

    @Before
    public void setup() {
        super.initializeDatabase();
        jwtUser.setUserName("Alex");
        jwtUser.setPassword("Qwerty123");
        jwtGenerator.setAuthService(new AuthService());
        jwtGenerator.setSecurityProperties(new SecurityProperties());
        tokenController = new TokenController(jwtGenerator);

    }

    @Test
    public void testGetterJwtGenerator() throws NoSuchFieldException, IllegalAccessException {
        final TokenController tokenController = new TokenController(new JwtGenerator());
        JwtGenerator jwtGenerator = new JwtGenerator();
        tokenController.setJwtGenerator(jwtGenerator);

        final Field field = tokenController.getClass().getDeclaredField("jwtGenerator");
        field.setAccessible(true);

        assertEquals("Fields didn't match", jwtGenerator, field.get(tokenController));
    }

    @Test
    public void testGetterAuthService() throws NoSuchFieldException, IllegalAccessException {
        final TokenController tokenController = new TokenController(new JwtGenerator());
        IAuthService authService = new AuthService();
        tokenController.setAuthService(authService);

        final Field field = tokenController.getClass().getDeclaredField("authService");
        field.setAccessible(true);

        assertEquals("Fields didn't match", authService, field.get(tokenController));
    }
}