package org.han.ica.oose.boterbloem.dao;


import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUtilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.UtilityDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;

import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class UtilityDaoImplTest extends JpaTestConfig {

    IUtilityDAO utilityDaoImplTest =  new UtilityDAOImpl();

    @Before
    public void setup(){
        utilityDaoImplTest.setEntityManager(em);
    }

    @Test
    public void findByNameTest(){
        UtilityEntity utilityEntity = utilityDaoImplTest.findByName("rollator");
        assertEquals("rollator", utilityEntity.getName());
    }
}
