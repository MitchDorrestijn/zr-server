package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntityPK;
import org.hibernate.QueryException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        assertTrue(!em.find(ClientcareinstitutionEntity.class,clientcareinstitutionEntityPK).isActive());
    }

    @Test
    public void removeByIdException(){
        try {
            clientDAO.removeById(80);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Executing an update/delete query");
        }
    }

    @Test
    public void getAllCaresById(){
        List<ClientEntity> clientEntities =  clientDAO.getByCareInstitutionId(2);
       assertEquals(1, clientEntities.size());
       try{
           clientDAO.getByCareInstitutionId(80);
       }catch (Exception e){
           assertEquals(e.getMessage(),"Executing an update/delete query");
       }
    }

    @Test
    public void latestId(){
        int latestId = clientDAO.latestId();
        System.out.println(latestId);
    }
}
