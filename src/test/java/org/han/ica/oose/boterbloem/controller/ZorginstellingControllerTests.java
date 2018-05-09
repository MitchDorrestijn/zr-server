package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.han.ica.oose.boterbloem.service.ZorginstellingService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZorginstellingControllerTests {

    private Zorginstelling zorginstellingA = new Zorginstelling(1, "instellingA");
    private Zorginstelling zorginstellingB = new Zorginstelling(2, "instellingB");
    private Zorginstelling zorginstellingC = new Zorginstelling(3, "instellingC");
    private Zorginstelling zorginstellingD = new Zorginstelling(4, "instellingD");
    private Zorginstelling zorginstellingE = new Zorginstelling(5, "instellingE");

    private List<Zorginstelling> zorginstellingen = new ArrayList<>();

    private ZorginstellingController zorginstellingController = new ZorginstellingController();
    ZorginstellingService zorginstellingService = mock(ZorginstellingService.class);


    @Before
    public void setup() {
        zorginstellingen.add(zorginstellingA);
        zorginstellingen.add(zorginstellingB);
        zorginstellingen.add(zorginstellingC);
        zorginstellingen.add(zorginstellingD);
        zorginstellingen.add(zorginstellingE);
        zorginstellingController.zorginstellingService = zorginstellingService;
    }


    @Test
    public void getAllZorginstellingenTets() throws SQLException {
        when(zorginstellingService.getAllZorginstellingen()).thenReturn(zorginstellingen);
        List<Zorginstelling> testZorginstellingen = zorginstellingController.getAllZorginstelling();
        assertEquals(5, testZorginstellingen.size());
    }

    @Test
    public void getZorginstellingTest() throws SQLException {
        when(zorginstellingService.findById(1)).thenReturn(zorginstellingA);
        Zorginstelling testZorginstelling = zorginstellingController.getZorginstelling("1");
        assertEquals("instellingA", testZorginstelling.getName());
    }


    @Test
    public void updateZorginstellingTest() throws SQLException{
        when(zorginstellingService.findById(1)).thenReturn(zorginstellingA);
        Zorginstelling testZorginstelling = zorginstellingController.getZorginstelling("1");
        testZorginstelling.setName("new name");
        zorginstellingController.updateUser(1,testZorginstelling);
        assertEquals("new name", testZorginstelling.getName());
    }

    @Test
    public void addZorgInstelling() throws SQLException{
        Zorginstelling zorginstellingZ = new Zorginstelling(6, "instellingZ");
        zorginstellingController.addZorginstelling(zorginstellingZ);
        when(zorginstellingService.findById(6)).thenReturn(zorginstellingZ);
        Zorginstelling testZorginstelling = zorginstellingController.getZorginstelling("6");
        assertEquals("instellingZ", testZorginstelling.getName());
    }
}
