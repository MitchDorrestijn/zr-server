package org.han.ica.oose.boterbloem;

import org.junit.*;
import org.junit.Assert;
import org.junit.runner.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class SpringBootWithReactJsApplicationTests {

    @Test
    public void contextLoads() {
        Assert.assertEquals(true, true);
    }

}