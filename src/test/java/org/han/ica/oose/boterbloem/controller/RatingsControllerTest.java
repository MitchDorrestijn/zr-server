package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUtilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.UtilityDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RatingsEntity;
import org.han.ica.oose.boterbloem.domain.domainmappers.RatingsMapper;
import org.han.ica.oose.boterbloem.domain.domainmappers.UtilityMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Rating;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;
import org.han.ica.oose.boterbloem.service.IRatingsService;
import org.han.ica.oose.boterbloem.service.IUtilityService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.RatingsService;
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
public class RatingsControllerTest extends JpaTestConfig {

    RatingsController ratingsController = new RatingsController();
    IRatingsService ratingsService = new RatingsService();
    RatingsMapper ratingsMapper = new RatingsMapper();
    IRatingsDAO ratingsDAO = new RatingsDAOImpl();

    @Before
    public void setup() {
        ratingsDAO.setEntityManager(em);
        ratingsMapper.setRatingsDAO(ratingsDAO);
        ratingsService.setRatingsMapper(ratingsMapper);
        ratingsController.setRatingsService(ratingsService);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetAllRatings(){
        List<Rating> ratingList = ratingsController.getAllRatings();
        assertEquals(10, ratingList.size());
    }

    @Test
    public void testGetAllRatingsFromASpecificDriverById(){
        List<Rating> ratingList = ratingsController.getAllRatingsFromASpecificDriverById(1);
        assertEquals(3, ratingList.size());
    }

    @Test
    public void testGetAllRatingsFromASpecificCareInstitution(){
        List<List<Rating>> ratingList = ratingsController.getAllRatingsFromASpecificCareInstitution(1);
        assertEquals(3, ratingList.size());
    }
}