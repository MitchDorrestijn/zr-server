package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntityPK;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class ClientDaoImplTest extends JpaTestConfig {

    IClientDAO clientDAO =  new ClientDAOImpl();

    @Before
    public void setup(){
        clientDAO.setEntityManager(em);
    }

    @Test
    public void removeById(){
        clientDAO.removeById(3);
        ClientcareinstitutionEntityPK clientcareinstitutionEntityPK =  new ClientcareinstitutionEntityPK();
        clientcareinstitutionEntityPK.setClientId(3);
        clientcareinstitutionEntityPK.setCareInstitutionId(2);
        assertTrue(em.find(ClientcareinstitutionEntity.class,clientcareinstitutionEntityPK).isActive());
    }

    @Test //(expected = Exception.class)
    public void removeByIdException(){
        clientDAO.removeById(100);
    }

}
