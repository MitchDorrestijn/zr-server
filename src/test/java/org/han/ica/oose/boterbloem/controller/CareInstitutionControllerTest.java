package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.service.serviceimplementation.CareInstitutionService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CareInstitutionControllerTest {

    private List<CareInstitution> careInstitutions = new ArrayList<>();
    private CareInstitutionService careInstitutionService = mock(CareInstitutionService.class);
    private CareInstitutionController careInstitutionController = new CareInstitutionController();

    private CareInstitution careInstitutionA = new CareInstitution();
    private CareInstitution careInstitutionB = new CareInstitution();
    private CareinstitutionEntity careinstitutionEntity = new CareinstitutionEntity();

    @Before
    public void setup(){
        careinstitutionEntity.setName("Ik wil een domain zijn");
        careinstitutionEntity.setId(4);

        careInstitutionA.setId(1);
        careInstitutionA.setName("Reinaarde");

        careInstitutionB.setId(2);
        careInstitutionB.setName("Cordaan");

        careInstitutions.add(careInstitutionA);
        careInstitutions.add(careInstitutionB);
        careInstitutionController.setCareInstitutionService(careInstitutionService);
    }

    @Test
    public void getAllCareInstitutionsTest() {
        when(careInstitutionService.getAllCareInstitutions()).thenReturn(careInstitutions);
        List<CareInstitution> testList = careInstitutionController.getAllCareInstitutions();
        assertEquals(2,testList.size());
    }

    @Test
    public void getAllCareInstitutionsTestFailed() {
        when(careInstitutionService.getAllCareInstitutions()).thenReturn(careInstitutions);
        List<CareInstitution> testList = careInstitutionController.getAllCareInstitutions();
        assertNotEquals(3,testList.size());
    }

    @Test
    public void getCareInstitutionById(){
        when(careInstitutionService.findById(4)).thenReturn(careinstitutionEntity);
        CareinstitutionEntity testCareinstitutionEntity = careInstitutionController.getCareInstitutionById(4);
        assertEquals(4,testCareinstitutionEntity.getId());
    }

    @Test
    public void getCareInstitutionByIdFailed(){
        when(careInstitutionService.findById(4)).thenReturn(careinstitutionEntity);
        CareinstitutionEntity testCareinstitutionEntity = careInstitutionController.getCareInstitutionById(4);
        assertNotEquals(5,testCareinstitutionEntity.getId());
    }

    @Test
    public void updateCareInstitution() {
        CareInstitution testCareInstitution = new CareInstitution();
        testCareInstitution.setId(5);
        testCareInstitution.setName("testZorginstelling");
        careInstitutionController.updateCareInstitution(testCareInstitution.getId(),careInstitutionA);
        assertEquals(5,careInstitutionA.getId());
    }

    @Test
    public void updateCareInstitutionFailed() {
        CareInstitution testCareInstitution = new CareInstitution();
        testCareInstitution.setId(5);
        testCareInstitution.setName("testZorginstelling");
        careInstitutionController.updateCareInstitution(testCareInstitution.getId(),careInstitutionA);
        assertNotEquals(6,careInstitutionA.getId());
    }

    @Test
    public void deleteCareInstitution(){
        careInstitutionController.deleteCareInstitutionById(1);
        assertEquals(null,careInstitutionController.getCareInstitutionById(1));
    }

    @Test
    public void deleteCareInstitutionFailed(){
        careInstitutionController.deleteCareInstitutionById(1);
        assertNotEquals(1,careInstitutionController.getCareInstitutionById(1));
    }

    @Test
    public void addCareInstitution(){
        CareinstitutionEntity toBeAdded = new CareinstitutionEntity();
        CareInstitution test = new CareInstitution();
        toBeAdded.setName("voeg mij toe");
        toBeAdded.setId(10);
        test.setId(toBeAdded.getId());
        test.setName(toBeAdded.getName());
        careInstitutionController.addCareInstitution(test);
        when(careInstitutionService.findById(10)).thenReturn(toBeAdded);
        CareinstitutionEntity testCareInstitution = careInstitutionController.getCareInstitutionById(10);
        assertEquals(10,testCareInstitution.getId());
    }

    @Test
    public void addCareInstitutionFailed(){
        CareinstitutionEntity toBeAdded = new CareinstitutionEntity();
        CareInstitution test = new CareInstitution();
        toBeAdded.setName("voeg mij toe");
        toBeAdded.setId(10);
        test.setId(toBeAdded.getId());
        test.setName(toBeAdded.getName());
        careInstitutionController.addCareInstitution(test);
        when(careInstitutionService.findById(10)).thenReturn(toBeAdded);
        CareinstitutionEntity testCareInstitution = careInstitutionController.getCareInstitutionById(10);
        assertNotEquals(11,testCareInstitution.getId());
    }

    //    @Test
//    public void addCareInstitutionTest() throws SQLException{
//        ICareInstitution careInstitutionZ = new ICareInstitution(6, "instellingZ");
//        careInstitutionController.addCareInstitution(careInstitutionZ);
//        when(careInstitutionService.findById(6)).thenReturn(careInstitutionZ);
//        ICareInstitution testCareInstitution = careInstitutionController.getCareInstitutionId("6");
//        assertEquals("instellingZ", testCareInstitution.getName());
//    }


//
//
//    @Test
//    public void updateCareInstitutionTest() throws SQLException{
//        when(careInstitutionService.findById(1)).thenReturn(careInstitutionA);
//        ICareInstitution testCareInstitution = careInstitutionController.getCareInstitutionId("1");
//        testCareInstitution.setName("new name");
//        careInstitutionController.updateCareInstitution(1, testCareInstitution);
//        assertEquals("new name", testCareInstitution.getName());
//    }

}
