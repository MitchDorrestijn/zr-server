package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientDAOTest {
    private ClientDAO dao;

    @Before
    public void setup() throws Exception {
        dao = new ClientDAO();
        dao.dao.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/create_script.sql'").execute();
        dao.dao.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/insert_script.sql'").execute();
    }

    @Test
    public void hasConnection() {
        assertTrue(dao.dao.hasConnection());
    }

    @Test
    public void getAllClients() throws SQLException {
        List<Client> clients = dao.getAllCliënts();
        assertEquals(0, clients.get(0).getClientId());
        assertEquals("Robin Schuiling", clients.get(0).getName());
        assertNotEquals(1, clients.get(2).getClientId());
        assertNotEquals("Barry Baringsma", clients.get(0).getName());
    }

    @Test
    public void getClientByID() throws SQLException {
        Client client = dao.getCliëntById(2);
        assertEquals(0, client.getClientId());
        assertNotEquals(2, client.getClientId());
    }

}
