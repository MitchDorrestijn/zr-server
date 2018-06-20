package org.han.ica.oose.boterbloem.dao;


import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RatingsEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class RatingsDaoImplTest extends JpaTestConfig {

    IRatingsDAO ratingsDAO = new RatingsDAOImpl();

    @Before
    public void setup() {
        ratingsDAO.setEntityManager(em);
    }

    @Test
    public void ratingsCareInstitution() {
        List<List<RatingsEntity>> lists = ratingsDAO.getByCareInstitution(1);
        assertEquals(3, lists.size());
    }

    @Test
    public void ratingsCareInstitutionException() {
        try {
            List<List<RatingsEntity>> lists = ratingsDAO.getByCareInstitution(90);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Executing an update/delete query");
        }
    }

    @Test
    public void ratingsTestException() {
        try {
            List<RatingsEntity> lists = ratingsDAO.getByDriver(567);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Executing an update/delete query");
        }
    }

}
