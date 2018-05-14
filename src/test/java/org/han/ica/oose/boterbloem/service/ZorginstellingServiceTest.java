package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.controller.ZorginstellingController;
import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ZorginstellingServiceTest {


    private Zorginstelling zorginstellingA = new Zorginstelling(1, "instellingA");
    private Zorginstelling zorginstellingB = new Zorginstelling(2, "instellingB");
    private Zorginstelling zorginstellingC = new Zorginstelling(3, "instellingC");
    private Zorginstelling zorginstellingD = new Zorginstelling(4, "instellingD");
    private Zorginstelling zorginstellingE = new Zorginstelling(5, "instellingE");

    private List<Zorginstelling> zorginstellingen = new ArrayList<>();

    private ZorginstellingService zorginstellingService = new ZorginstellingService();
    private DAO dao = mock(DAO.class);
    private ZorginstellingDAO zorginstellingDAO = mock(ZorginstellingDAO.class);
    private Connection connection = mock(Connection.class);


    @Before
    public void setup() throws SQLException {


        zorginstellingen.add(zorginstellingA);
        zorginstellingen.add(zorginstellingB);
        zorginstellingen.add(zorginstellingC);
        zorginstellingen.add(zorginstellingD);
        zorginstellingen.add(zorginstellingE);
        dao.setConnection(connection);
        zorginstellingDAO.dao = dao;
        zorginstellingService.zorginstellingDAO = zorginstellingDAO;
    }


    @Test
    public void getAllZorginstellingen() throws SQLException {
        when(zorginstellingDAO.getAllZorginstellingen()).thenReturn(zorginstellingen);
        List<Zorginstelling> testZorginstellingen = zorginstellingService.getAllZorginstellingen();
        assertEquals(5, testZorginstellingen.size());
    }

    @Test
    public void addZorginstelling() throws SQLException{

        Zorginstelling zorginstellingZ = new Zorginstelling(6, "instellingZ");
        zorginstellingService.saveZorginstelling(zorginstellingZ);
        when(zorginstellingService.findById(6)).thenReturn(zorginstellingZ);
        Zorginstelling testZorginstelling = zorginstellingService.findById(6);
        assertEquals("instellingZ", testZorginstelling.getName());
    }
}

