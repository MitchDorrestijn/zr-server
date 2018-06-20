package org.han.ica.oose.boterbloem.display.displaymapper;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RidesByCareinstitutionDisplay;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class RideDisplayMapperTest {

    RideDisplayMapper rideDisplayMapper = new RideDisplayMapper();

    @Before
    public void setup(){
    }

    @Test
    public void getAllRidesByInstitutionTest(){
        List<RidesByCareinstitutionDisplay> ridesByCareinstitutionDisplayList = rideDisplayMapper.getAllRidesByInstitution(1);
        assertEquals(2,ridesByCareinstitutionDisplayList.size());
    }

    @Test
    public void getPaymentsAtCareInstitutionTest(){
        List<RideOverviewDisplay> rideOverviewDisplays = rideDisplayMapper.getPaymentsAtCareinstitution(1);
        assertEquals(2,rideOverviewDisplays.size());
    }
}
