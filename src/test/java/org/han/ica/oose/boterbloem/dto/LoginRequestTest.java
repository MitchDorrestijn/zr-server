package org.han.ica.oose.boterbloem.dto;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginRequestTest {


    @Test
    public void LoginRequestConstructorTest() {
        LoginRequest loginRequesttest = new LoginRequest("Ben", "Password");

        assertEquals("Ben", loginRequesttest.username);
        assertEquals("Password", loginRequesttest.password);
    }
}
