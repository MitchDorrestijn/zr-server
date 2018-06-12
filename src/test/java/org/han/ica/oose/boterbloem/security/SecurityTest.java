package org.han.ica.oose.boterbloem.security;

import static org.junit.Assert.assertEquals;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class SecurityTest extends JpaTestConfig {
    private SecurityProperties securityProperties = new SecurityProperties();
    private JwtValidator jwtValidator = new JwtValidator();

    @Test
    public void testTokenValidator(){
        assertEquals(null, jwtValidator.validate("token"));
    }

    @Test
    public void testGetApplicationProperties(){
        assertEquals(null,securityProperties.getSigningkey());
    }

    @Test
    public void testDefaultAntPattern(){
        assertEquals(null,securityProperties.getDefaultAntPattern());
    }
}
