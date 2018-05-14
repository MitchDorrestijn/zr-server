package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.controller.ZorginstellingController;
import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
    private ZorginstellingDAO zorginstellingDAO = mock(ZorginstellingDAO.class);


    @Before
    public void setup() throws SQLException {


        zorginstellingen.add(zorginstellingA);
        zorginstellingen.add(zorginstellingB);
        zorginstellingen.add(zorginstellingC);
        zorginstellingen.add(zorginstellingD);
        zorginstellingen.add(zorginstellingE);
        zorginstellingService.zorginstellingDAO = zorginstellingDAO;
    }


    @Test
    public void getAllZorginstellingen() throws SQLException {
        when(zorginstellingDAO.getAllZorginstellingen()).thenReturn(zorginstellingen);
        List<Zorginstelling> testZorginstellingen = zorginstellingService.getAllZorginstellingen();
        assertEquals(5, testZorginstellingen.size());
    }

    @Test
    public void whenCreateNoException() {
        // When
        zorginstellingService.saveZorginstelling(zorginstellingA);
    }

    @Test
    public void whenCreateIsTriggered_thenEntityIsCreated() {
        // When

        this.zorginstellingService.saveZorginstelling(zorginstellingA);

        // Then
        ArgumentCaptor<Zorginstelling> argument = ArgumentCaptor.forClass(Zorginstelling.class);
        verify(zorginstellingDAO).create(argument.capture());
        assertEquals(zorginstellingA.getName(), argument.getValue().getName());
    }

    @Test
    public void whenUpdateNoException() {
        zorginstellingService.updateZorginstelling(zorginstellingA);
    }

    @Test
    public void whenUpdateIsTriggered_ThenEntityUpdated() {
        this.zorginstellingService.updateZorginstelling(zorginstellingA);

        ArgumentCaptor<Zorginstelling> argument = ArgumentCaptor.forClass(Zorginstelling.class);
        verify(zorginstellingDAO).updateZorginstelling(argument.capture());
        assertEquals(zorginstellingA.getName(), argument.getValue().getName());
    }

    @Test
    public void findByIdTest(){
        when(zorginstellingDAO.getByID(1)).thenReturn(zorginstellingA);
        Zorginstelling zorginstelling = zorginstellingService.findById(1);

        assertEquals(zorginstellingA.getName(), zorginstelling.getName());

    }

}

