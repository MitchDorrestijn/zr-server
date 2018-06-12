package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.service.serviceimplementation.CareInstitutionService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
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
        List<CareinstitutionEntity> testCareinstitutionEntity = careInstitutionController.getCareInstitutionById(4);
       assertEquals(4,testCareinstitutionEntity.get(0).getId());
    }

    @Test
    public void getCareInstitutionByIdFailed(){
        when(careInstitutionService.findById(4)).thenReturn(careinstitutionEntity);
        List<CareinstitutionEntity> testCareinstitutionEntity = careInstitutionController.getCareInstitutionById(4);
        assertNotEquals(5,testCareinstitutionEntity.get(0).getId());
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
        List<String> testList = new ArrayList<>();
        testList.add(null);
        assertEquals(testList,careInstitutionController.getCareInstitutionById(1));
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
        toBeAdded.setHouseNumber("30");
        toBeAdded.setResidence("Arnhem");
        toBeAdded.setStreet("Ruitenberglaat 30");
        toBeAdded.setZipCode("0000");
        test.setId(toBeAdded.getId());
        test.setName(toBeAdded.getName());
        test.setAddresses(test.getAddresses());
        careInstitutionController.addCareInstitution(test);
        when(careInstitutionService.findById(10)).thenReturn(toBeAdded);
        List<CareinstitutionEntity> testCareInstitution = careInstitutionController.getCareInstitutionById(10);
        assertEquals(10,testCareInstitution.get(0).getId());
    }

    @Test
    public void addCareInstitutionFailed(){
        CareinstitutionEntity toBeAdded = new CareinstitutionEntity();
        CareInstitution test = new CareInstitution();
        List<Address> adresses = new ArrayList<>();
        adresses.add(new Address());
        toBeAdded.setName("voeg mij toe");
        toBeAdded.setId(10);
        test.setId(toBeAdded.getId());
        test.setName(toBeAdded.getName());
        test.setAddresses(adresses);
        careInstitutionController.addCareInstitution(test);
        when(careInstitutionService.findById(10)).thenReturn(toBeAdded);
        List<CareinstitutionEntity> testCareInstitution = careInstitutionController.getCareInstitutionById(10);
        assertNotEquals(11,testCareInstitution.get(0).getId());
    }

}
