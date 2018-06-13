package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDrivercarDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.DrivercarDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
import org.han.ica.oose.boterbloem.service.serviceimplementation.DriverService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class DriverServiceTest extends JpaTestConfig {


    private List<Driver> driverList = new ArrayList<>();
    private DriverService driverService = new DriverService();
    IDrivercarDAO drivercarDAO =  new DrivercarDAOImpl();

    @Before
    public void setup() throws SQLException {

    }

    @Test
    public void getAllDrivers() throws SQLException {
        DrivercarEntity drivercarEntity = drivercarDAO.findCarById(1);
        System.out.println(drivercarEntity.getNumberPlate());
    }


}
