package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ILimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.LimitationDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.LimitationEntity;
import org.han.ica.oose.boterbloem.domain.domainmappers.LimitationMapper;
import org.han.ica.oose.boterbloem.service.ILimitationService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.LimitationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class LimitationControllerTest extends JpaTestConfig {
    LimitationController limitationController = new LimitationController();
    ILimitationService limitationService = new LimitationService();
    ILimitationDAO limitationDAO = new LimitationDAOImpl();

    @Before
    public void setup() {
        limitationDAO.setEntityManager(em);
        limitationService.setLimitationDAO(limitationDAO);
        limitationController.setLimitationService(limitationService);
    }

    @Test
    public void testGetAllLimitations() {
        List<LimitationEntity> limitationEntities = limitationController.getAllLimitations();
        assertEquals("geestelijk gehandicapten", limitationEntities.get(1).getName());
    }

    @Test
    public void testGetLimitationByName() {
        LimitationEntity limitationEntity = limitationController.getByName("ouderen");
        assertEquals("ouderen", limitationEntity.getName());
    }

    @Test
    public void testAddLimitation() {
        LimitationEntity limitationEntity = new LimitationEntity();
        limitationEntity.setName("Verstandelijk gehandicapten");
        limitationController.addLimitation(limitationEntity);
        assertEquals("Verstandelijk gehandicapten", limitationController.getByName("Verstandelijk gehandicapten"));
    }

    @Test
    public void testUpdateLimitation() {
        LimitationEntity limitationEntity = new LimitationEntity();
        limitationEntity.setName("Dementie");
        limitationController.updateLimitation("geestelijk gehandicapten", limitationEntity);
        assertEquals("Dementie", limitationController.getByName("Dementie"));
    }

    @Test
    public void testDeleteLimitation() {
        LimitationEntity limitationEntity = new LimitationEntity();
        limitationEntity.setName("Verstandelijk gehandicapten");
        limitationController.addLimitation(limitationEntity);
        assertEquals("Verstandelijk gehapdicapten", limitationController.getByName("Verstandelijk gehandicapten"));
        limitationController.deleteLimitation("Verstandelijk gehandicapten");
        assertNotEquals("Verstandelijk gehapdicapten", limitationController.getByName("Verstandelijk gehandicapten"));
    }
}
