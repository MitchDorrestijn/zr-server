package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.DriverCar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class DriverCarMapperTest extends JpaTestConfig {

    private DriverCar driverCar = new DriverCar();
    private DriverCarMapper driverCarMapper = new DriverCarMapper();


    @Before
    public void setup() {
        driverCar.setNumberOfPassengers(3);
    }

    @Test
    public void testConvertDriverCar() {
        int expected = driverCar.getNumberOfPassengers();

        DrivercarEntity drivercarEntity = driverCarMapper.convertDriverCar(driverCar);

        int actual = drivercarEntity.getNumberOfPassengers();
        assertEquals(expected, actual);
    }
}
