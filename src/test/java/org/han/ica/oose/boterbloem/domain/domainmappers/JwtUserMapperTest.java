package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.utils.exceptions.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class JwtUserMapperTest extends JpaTestConfig {

    private JwtUserMapper jwtUserMapper = new JwtUserMapper();
    private AuthUsersEntity authUsersEntity = new AuthUsersEntity();

    @Before
    public void setup() {
        authUsersEntity.setUserName("Frits");
    }

    @Test(expected = UserNotFoundException.class)
    public void testConvertDriverCar() {
        String expected = authUsersEntity.getUserName();

        JwtUser jwtUser = jwtUserMapper.convertEntityToDomain(authUsersEntity);

        String actual = jwtUser.getUserName();
        assertEquals(expected, actual);
    }
}
