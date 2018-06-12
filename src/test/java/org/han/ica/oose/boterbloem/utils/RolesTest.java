package org.han.ica.oose.boterbloem.utils;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.utils.enumerations.Roles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class RolesTest extends JpaTestConfig {

    @Test
    public void testEnumTypes() {
        assertEquals(Roles.ROLE_ZORGINSTELLING.toString(), "ROLE_ZORGINSTELLING");
        assertEquals(Roles.ROLE_ADMIN.toString(), "ROLE_ADMIN");
    }
}
