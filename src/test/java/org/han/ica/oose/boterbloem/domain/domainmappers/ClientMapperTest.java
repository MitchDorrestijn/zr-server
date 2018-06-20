package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientlimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientlimitationDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class ClientMapperTest extends JpaTestConfig {

    private Client client = new Client();
    private ClientMapper clientMapper = new ClientMapper();
    private IClientDAO clientDAO = new ClientDAOImpl();
    private LimitationMapper limitationMapper = new LimitationMapper();
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();

    @Before
    public void setup() {
        clientDAO.setEntityManager(em);
        clientMapper.setLimitationMapper(limitationMapper);
        clientMapper.setClientlimitationDAO(clientlimitationDAO);

        client.setFirstName("Robin");
        client.setCompanion("Sven");
    }

    @Test
    public void extractClientTest() {
        Client clientA = clientMapper.extractClient(clientDAO.findById(2));
        String expected = client.getCompanion();
        String actual = clientA.getCompanion();

        assertEquals(expected, actual);
    }

    @Test
    public void extractClientTestFailed() {
        Client clientA = clientMapper.extractClient(clientDAO.findById(3));
        String expected = client.getCompanion();
        String actual = clientA.getCompanion();

        assertNotEquals(expected, actual);
    }

    @Test
    public void convertClientTest() {
        ClientEntity clientEntity = clientMapper.convertClient(clientMapper.extractClient(clientDAO.findById(2)));
        String expected = client.getFirstName();
        String actual = clientEntity.getUserEntity().getFirstName();

        assertEquals(expected, actual);
    }

    @Test
    public void convertClientTestFailed() {
        ClientEntity clientEntity = clientMapper.convertClient(clientMapper.extractClient(clientDAO.findById(3)));
        String expected = client.getFirstName();
        String actual = clientEntity.getUserEntity().getFirstName();

        assertNotEquals(expected, actual);
    }
}
