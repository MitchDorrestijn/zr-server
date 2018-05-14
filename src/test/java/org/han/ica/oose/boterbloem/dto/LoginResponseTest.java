package org.han.ica.oose.boterbloem.dto;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginResponseTest {


    @Test
    public void LoginResponseConstructorTest() {
        LoginResponse loginResponsetest = new LoginResponse("Ben", "someToken", "admin");

        assertEquals("Ben", loginResponsetest.user);
        assertEquals("someToken", loginResponsetest.token);
        assertEquals("admin", loginResponsetest.administratorLevel);
    }
}
