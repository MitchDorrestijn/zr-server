//package org.han.ica.oose.boterbloem.dao;
//
//import org.han.ica.oose.boterbloem.domain.Client;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ClientDAOTest {
//    private ClientDAO dao;
//
//    @Before
//    public void setup() throws Exception {
//        dao = new ClientDAO();
//        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/create_script.sql'").execute();
//        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/insert_script.sql'").execute();
//        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/alter_script.sql'").execute();
//    }
//
//    @Test
//    public void create() {
//        dao.create(new Client(1, "Arnold", "Wandelstok", true));
//        Client temp = dao.getClientById(1);
//        assertEquals(1, temp.getClientId());
//        assertEquals("Arnold", temp.getCompanion());
//        assertEquals("Wandelstok", temp.getUtility());
//        assertEquals(true, temp.isDriverPreferenceF());
//        //TODO: Create method delete
//        dao.deleteClient(1);
//    }
//}
//=======
//package org.han.ica.oose.boterbloem.dao;
//
//import org.han.ica.oose.boterbloem.domain.Client;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ClientDAOTest {
//
//    private ClientDAO dao;
//
//    @Before
//    public void setup() throws Exception {
//        dao = new ClientDAO();
//        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/create_script.sql'").execute();
//        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/insert_script.sql'").execute();
//    }
//
//    @Test
//    public void hasConnection() {
//        assertTrue(dao.CONNECTION_DAO.hasConnection());
//    }
//
//    @Test
//    public void getAllClients() throws SQLException {
//        List<Client> clients = dao.getAllClients();
//        assertEquals(0, clients.get(0).getClientId());
//        assertEquals("Robin Schuiling", clients.get(0).getName());
//        assertNotEquals(1, clients.get(2).getClientId());
//        assertNotEquals("Barry Baringsma", clients.get(0).getName());
//    }
//
//    @Test
//    public void getClientByID() throws SQLException {
//        Client client = dao.getClientById(2);
//        assertEquals(0, client.getClientId());
//        assertNotEquals(2, client.getClientId());
//    }
//
//    @Test
//    public void create() {
//        dao.create(new Client(1, "Arnold", "Wandelstok", true));
//        Client temp = dao.getClientById(1);
//        assertEquals(1, temp.getClientId());
//        assertEquals("Arnold", temp.getCompanion());
//        assertEquals("Wandelstok", temp.getUtility());
//        assertEquals(true, temp.isDriverPreferenceF());
//        //TODO: Create method delete
//       // dao.deleteClient(1);
//    }
//}
