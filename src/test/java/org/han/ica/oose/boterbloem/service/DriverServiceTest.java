package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.controller.DriverController;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntity;
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
@WithMockUser(username = "Mitch", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class DriverServiceTest extends JpaTestConfig {


    private DriverService driverService = new DriverService();
    private DriverController driverController = new DriverController();

    private CreateDriverDisplay createDriverDisplay = new CreateDriverDisplay();

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

        driverController.setDriverService(driverService);



        createDriverDisplay.setCareInstitutionId(1);

        DriverEntity driverEntity = new DriverEntity();
        UserEntity userEntity = new UserEntity();
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

    }

    @Test
    public void getAllDriversTest() {
        List<DrivercarEntity> drivers = driverService.getAllDrivers();
        assertEquals(6, drivers.size());
    }

    @Test
    public void getAllDriversNot() {
        List<DrivercarEntity> drivers = driverService.getAllDrivers();
        assertNotEquals(7, drivers.size());
    }

    @Test
    public void testfindById() {
        assertEquals(1, driverService.findById(1).getDriverId());
    }


    @Test
    public void testfindByIdNot() {
        assertNotEquals(2, driverService.findById(1).getDriverId());
    }

    @Test
    public void getDriverDetailsTest() {
        DriverDetailDisplay driverDetailDisplay = driverService.getDriverDetails(1);

        assertEquals(1, driverDetailDisplay.getDriver().getDriverId());
    }

    @Test
    public void allDriversWithStatisticsTest() {
        List<DriverDisplay> driverDisplays = driverService.allDriversWithStatistics();
        assertEquals(8, driverDisplays.size());
    }

    @Test
    public void createDriverTets() {

        driverController.createDriver(createDriverDisplay);

        int latestId = driverDao.latestId();
        assertEquals("asd", driverDao.findById(latestId).getUserEntity().getFirstName());
        createDriverDisplay.getDriver().getUserEntity().setId(latestId);
        createDriverDisplay.getDriver().setDriverId(latestId);
        createDriverDisplay.getDriver().getUserEntity().setFirstName("Henk");
        driverController.updateDriverDetails(createDriverDisplay);

        assertEquals("Henk", driverDao.findById(latestId).getUserEntity().getFirstName());

        driverController.deleteDriverById(latestId);
       boolean active = (boolean) em.createQuery("select active from DrivercareinstitutionEntity where driverId = :latestId").setParameter("latestId",latestId).getSingleResult();
        assertFalse(active);


    }

    @Test
    public void getAllDriverFromCareInstitution(){
        List<DriverDisplay> driverDisplays =driverController.getAllDriversFromASpecificCareInstitution(1);
        assertEquals(3,driverDisplays.size());
}

    @Test
    public void getDriverByIdTest(){
        DriverEntity driverEntity =  driverController.getDriverById(1);
        assertEquals(1,driverEntity.getUserEntity().getId());
    }

    @Test
    public void getAllDrivers(){
        List<DriverDisplay> driverDisplays =  driverController.getAllDrivers();
        assertEquals(8,driverDisplays.size());
    }

    @Test
    public void getDriverDetailsTestController(){
        DriverDetailDisplay driverDetailDisplay = driverController.getDriverDetails(1);
        assertEquals(1,driverDetailDisplay.getDriver().getUserEntity().getId());
    }
}
