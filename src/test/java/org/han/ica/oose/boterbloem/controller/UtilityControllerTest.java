package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUtilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.UtilityDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainmappers.UtilityMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;
import org.han.ica.oose.boterbloem.service.IUtilityService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.UtilityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class UtilityControllerTest extends JpaTestConfig {
    UtilityController utilityController = new UtilityController();
    IUtilityService utilityService = new UtilityService();
    UtilityMapper utilityMapper = new UtilityMapper();
    IUtilityDAO utilityDAO = new UtilityDAOImpl();

    @Before
    public void setup() {
        utilityDAO.setEntityManager(em);
        utilityMapper.setUtilityDAO(utilityDAO);
        utilityService.setUtilityMapper(utilityMapper);
        utilityController.setUtilityService(utilityService);
    }

    @Test
    public void testGetAllUtilities(){
        List<Utility> utilityList = utilityController.getAllUtilities();
        assertEquals("scootmobiel", utilityList.get(0).getUtility());
    }
}