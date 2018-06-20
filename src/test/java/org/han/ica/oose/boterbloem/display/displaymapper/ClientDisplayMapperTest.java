package org.han.ica.oose.boterbloem.display.displaymapper;
import com.mysql.cj.xdevapi.AddResult;
import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.CareinstitutionDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UserEntity;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.CareinstitutionMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.domain.domainobjects.Client;
import org.han.ica.oose.boterbloem.service.serviceimplementation.CareInstitutionService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class ClientDisplayMapperTest extends JpaTestConfig {

    ClientDisplayMapper clientDisplayMapper = new ClientDisplayMapper();
    ClientDAOImpl clientDAO = new ClientDAOImpl();
    RideDAOImpl rideDAO = new RideDAOImpl();
    @Before
    public void setup(){
        clientDAO.setEntityManager(em);
        rideDAO.setEntityManager(em);
        clientDisplayMapper.setRideDAO(rideDAO);
        clientDisplayMapper.setClientDAO(clientDAO);
    }

    @Test
    public void getAllClientsTest(){
        List<ClientDisplay> clients = clientDisplayMapper.getAllClients();
        assertEquals(5,clients.size());
    }

    @Test
    public void getAllClientsFromASpecificCareInstitutionTest(){
        List<ClientDisplay> clients = clientDisplayMapper.getAllClientsFromASpecificCareInstitution(1);
        assertEquals(1,clients.size());
    }

    @Test
    public void fillClientDisplayTest(){
        ClientEntity clientEntity = new ClientEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Freek");
        userEntity.setLastName("Vonk");
        clientEntity.setUserEntity(userEntity);

        clientEntity.setCompanion("TestCompanion");
        ClientDisplay testDisplay = clientDisplayMapper.fillClientDisplay(clientEntity);
        assertEquals(null, testDisplay.getCompanion());
    }

    @Test
    public void emptyTestForCoverage(){

    }
}

