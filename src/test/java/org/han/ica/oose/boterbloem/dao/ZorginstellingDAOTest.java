package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ZorginstellingDAOTest {

    private ZorginstellingDAO dao;

    @Before
    public void setup() throws Exception {
        dao = new ZorginstellingDAO();
        dao.dao.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/create_script.sql'").execute();
        dao.dao.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/insert_script.sql'").execute();
    }

    @Test
    public void hasConnection() {
        assertTrue(dao.dao.hasConnection());
    }

    @Test
    public void create() {
        dao.create(new Zorginstelling(6, "Prothese"));
        Zorginstelling temp = dao.getByID(6);
        assertEquals(6, temp.getId());
        assertEquals("Prothese", dao.getByName("Prothese").get(0).getName());
        dao.deleteById(6);
    }

    @Test
    public void getAllZorginstellingen() {
        List<Zorginstelling> zorginstellingen = dao.getAllZorginstellingen();
        assertEquals(1, zorginstellingen.get(0).getId());
        assertEquals("Reinearde", zorginstellingen.get(0).getName());
        assertNotEquals(1, zorginstellingen.get(2).getId());
        assertNotEquals("Cordaan", zorginstellingen.get(0).getName());
    }

    @Test
    public void getByID() {
        Zorginstelling zorginstelling = dao.getByID(1);
        assertEquals(1, zorginstelling.getId());
        assertNotEquals(2, zorginstelling.getId());
    }

    @Test
    public void getByName() {
        List<Zorginstelling> zorginstellingen = dao.getByName("Reinearde");
        assertEquals("Reinearde", zorginstellingen.get(0).getName());
        assertNotEquals("Cordaan", zorginstellingen.get(0).getName());
    }

    @After
    public void tearDown() {
        dao.dao.closeConnection();
    }
}