package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClientDAOTest {
    private ClientDAO dao;

    @Before
    public void setup() throws Exception {
        dao = new ClientDAO();
        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/create_script.sql'").execute();
        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/insert_script.sql'").execute();
        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/alter_script.sql'").execute();
    }

    @Test
    public void create() {
        dao.create(new Client(1, "Arnold", "Wandelstok", true));
        //TODO: Create method getByID
        Client temp = dao.getByID(1);
        assertEquals(1, temp.getClientId());
        assertEquals("Arnold", temp.getCompanion());
        assertEquals("Wandelstok", temp.getUtility());
        assertEquals(true, temp.isDriverPreferenceF());
        //TODO: Create method delete
        dao.delete(1);
    }
}
