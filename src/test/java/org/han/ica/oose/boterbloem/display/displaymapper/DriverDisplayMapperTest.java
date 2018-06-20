package org.han.ica.oose.boterbloem.display.displaymapper;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class DriverDisplayMapperTest extends JpaTestConfig {

    DriverDisplayMapper driverDisplayMapper = new DriverDisplayMapper();
    @Before
    public void setup(){
    }

    @Test
    public void fillDisplayTest(){
        Driver driver = new Driver();
        driver.setTotalRides(10);
        DriverDisplay driverDisplay = driverDisplayMapper.fillDisplay(driver);
        assertEquals(10,driverDisplay.getTotalRides());
    }

}
