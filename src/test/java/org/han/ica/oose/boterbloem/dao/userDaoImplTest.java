package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUserDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.UserDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class userDaoImplTest extends JpaTestConfig {

    UserDAOImpl userDAO = new UserDAOImpl();

    @Before
    public void setup() {
        userDAO.setEntityManager(em);


    }

    @Test
    public void driverByNameTest() {
        String name = userDAO.driverNameById(2);
        assertEquals("Robin", name);
    }

    @Test
    public void ExeptiontestName(){
        try{
            String name =  userDAO.driverNameById(80);
        }catch (Exception e){
            assertEquals(e.getMessage(), "Executing an update/delete query");
        }
    }

}
