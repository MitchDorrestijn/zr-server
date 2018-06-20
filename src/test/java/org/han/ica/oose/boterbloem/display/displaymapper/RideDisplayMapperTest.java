package org.han.ica.oose.boterbloem.display.displaymapper;
import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.DrivercarDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RidesByCareinstitutionDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.RideMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class RideDisplayMapperTest extends JpaTestConfig {

    RideDisplayMapper rideDisplayMapper = new RideDisplayMapper();
    RideMapper rideMapper = new RideMapper();
    RideDAOImpl rideDAO = new RideDAOImpl();
    DrivercarDAOImpl drivercarDAO = new DrivercarDAOImpl();

    @Before
    public void setup(){
        rideDAO.setEntityManager(em);
        drivercarDAO.setEntityManager(em);
        rideMapper.setRideDAO(rideDAO);
        rideMapper.setDrivercarDAO(drivercarDAO);
    }

    @Test
    public void getAllRidesByInstitutionTest(){
        List<RidesByCareinstitutionDisplay> ridesByCareinstitutionDisplayList = rideDisplayMapper.getAllRidesByInstitution(1);
        assertEquals(ridesByCareinstitutionDisplayList.size(),ridesByCareinstitutionDisplayList.size());
    }

    @Test
    public void getPaymentsAtCareInstitutionTest(){
        List<RideOverviewDisplay> rideOverviewDisplays = rideDisplayMapper.getPaymentsAtCareinstitution(1);
        assertEquals(rideOverviewDisplays.size(),rideOverviewDisplays.size());
    }
}
