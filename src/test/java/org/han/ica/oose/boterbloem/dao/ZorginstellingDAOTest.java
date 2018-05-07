package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ZorginstellingDAOTest {

    private ZorginstellingDAO dao;

    @Mock
    private List<Zorginstelling> zorginstellingenMock;

    @Mock
    private Zorginstelling zorginstellingMock;

    @Before
    public void setup() {
        dao = new ZorginstellingDAO();
    }

    @Test
    public void create() {
        System.out.println(dao.dao.hasConnection());
        //dao.create(new Zorginstelling(6, "Prothese"));
        Zorginstelling temp = dao.getByID(6);
        assertEquals(6, temp.getId());
        assertEquals("Prothese", dao.getByName("Prothese").get(0).getName());
        dao.deleteById(6);
    }

    @Test
    public void getAllZorginstellingen() {
        when(dao.getAllZorginstellingen()).thenReturn(zorginstellingenMock);

        List<Zorginstelling> zorginstellingen = dao.getAllZorginstellingen();
        assertEquals(zorginstellingenMock, zorginstellingen);

    }

    @Test
    public void getByID() {
        when(dao.getByID(1)).thenReturn(zorginstellingMock);

        Zorginstelling zorginstelling = dao.getByID(1);
        assertEquals(zorginstellingMock, zorginstelling);
    }

    @Test
    public void getByName() {
        when(dao.getByName("Reinearde")).thenReturn(zorginstellingenMock);

        List<Zorginstelling> zorginstellingen = dao.getByName("Reinearde");
        assertEquals(zorginstellingenMock, zorginstellingen);
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void deleteByName() {
    }
}