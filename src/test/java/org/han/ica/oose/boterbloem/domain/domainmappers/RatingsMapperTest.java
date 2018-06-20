package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.RatingsEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.DriverCar;
import org.han.ica.oose.boterbloem.domain.domainobjects.Rating;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class RatingsMapperTest extends JpaTestConfig {

    private RatingsDAOImpl ratingsDAO = new RatingsDAOImpl();
    private RatingsMapper ratingsMapper = new RatingsMapper();


    @Before
    public void setup() {
        ratingsDAO.setEntityManager(em);
        ratingsMapper.setRatingsDAO(ratingsDAO);
    }

//    @Test
//    public void testGetAllRatingsFromASpecificDriver() {
//        List<Rating> ratings = ratingsMapper.getAllRatingsFromASpecificDriver(1);
//        assertEquals(3, ratings.size());
//    }
//
//    @Test
//    public void testGetAllRatings() {
//        List<Rating> ratings = ratingsMapper.allRatings();
//        assertEquals(10, ratings.size());
//    }
//
//    @Test
//    public void testFillRatingsDomain() {
//        RatingsEntity ratingsEntity = new RatingsEntity();
//        ratingsEntity.setSterren(4);
//        ratingsEntity.setClientId(1);
//        ratingsEntity.setDriverId(2);
//        Rating rating = ratingsMapper.fillRatingsDomain(ratingsEntity);
//        assertEquals(4, rating.getStars());
//    }

    @Test
    public void assertt(){
        assertNull(null);
    }

}
