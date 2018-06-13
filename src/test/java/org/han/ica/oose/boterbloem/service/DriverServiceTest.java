package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UserEntity;
import org.han.ica.oose.boterbloem.display.displayobject.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.DriverCarMapper;
import org.han.ica.oose.boterbloem.domain.domainmappers.DriverMapper;
import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
@WithMockUser(username="Mitch",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class DriverServiceTest extends JpaTestConfig {


    private DriverService driverService = new DriverService();

    private IDriverDAO driverDao = new DriverDAOImpl();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();
    private IDrivercareinstitutionDAO drivercareinstitutionDAO = new DrivercareinstitutionDAOImpl();
    private IDriverlimitationmanageableDAO driverlimitationmanageableDAO = new DriverlimitationmanageableDAOImpl();
    private DriverMapper driverMapper = new DriverMapper();
    private IUserDAO userDAO = new UserDAOImpl();
    private DriverCarMapper driverCarMapper = new DriverCarMapper();
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();

    @Before
    public void setup() throws SQLException {
        drivercarDAO.setEntityManager(em);
        driverDao.setEntityManager(em);
        drivercareinstitutionDAO.setEntityManager(em);
        driverlimitationmanageableDAO.setEntityManager(em);
        userDAO.setEntityManager(em);
        ratingsDAO.setEntityManager(em);
        rideDAO.setEntityManager(em);

        driverService.setDrivercarDAO(drivercarDAO);
        driverService.setDrivercareinstitutionDAO(drivercareinstitutionDAO);
        driverService.setDriverDao(driverDao);
        driverService.setDriverlimitationmanageableDAO(driverlimitationmanageableDAO);
        driverService.setUserDAO(userDAO);

        driverMapper.setDrivercarDAO(drivercarDAO);
        driverMapper.setDriverDAO(driverDao);
        driverMapper.setRatingsDAO(ratingsDAO);
        driverMapper.setRideDAO(rideDAO);

        driverService.setDriverMapper(driverMapper);

    }

    @Test
    public void getAllDriversTest()   {
        List<DrivercarEntity> drivers = driverService.getAllDrivers();
        assertEquals(6,drivers.size());
    }

    @Test
    public void getAllDriversNot()   {
        List<DrivercarEntity> drivers = driverService.getAllDrivers();
        assertNotEquals(7,drivers.size());
    }

    @Test
    public void testfindById(){
        assertEquals(1,driverService.findById(1).getDriverId());
    }


    @Test
    public void testfindByIdNot(){
        assertNotEquals(2,driverService.findById(1).getDriverId());
    }

    @Test
    public void getDriverDetailsTest(){
        DriverDetailDisplay driverDetailDisplay = driverService.getDriverDetails(1);

        assertEquals(1,driverDetailDisplay.getDriver().getDriverId());
    }

    @Test
    public void allDriversWithStatisticsTest(){
        List<DriverDisplay> driverDisplays = driverService.allDriversWithStatistics();
        assertEquals(8,driverDisplays.size());
    }

    @Test
    public void createDriverTets(){
        CreateDriverDisplay createDriverDisplay =  new CreateDriverDisplay();
        createDriverDisplay.setCareInstitutionId(1);

        DriverEntity driverEntity =  new DriverEntity();
        UserEntity userEntity  = new UserEntity();
        userEntity.setFirstName("asd");
        userEntity.setLastName("asd");
        userEntity.setEmail("asd");
        driverEntity.setUserEntity(userEntity);
        driverEntity.setAccountnr("asd");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ouderen");


        createDriverDisplay.setDriver(driverEntity);
        createDriverDisplay.setDrivercar(drivercarDAO.findCarById(1));
        createDriverDisplay.setLimitations(arrayList);

        driverService.createChauffeur(createDriverDisplay);

        int latestId = driverDao.latestId();
        assertEquals("asd",driverDao.findById(latestId).getUserEntity().getFirstName());
}

}
