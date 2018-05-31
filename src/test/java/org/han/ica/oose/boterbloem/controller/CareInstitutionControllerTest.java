package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dataAccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.service.serviceImplementation.CareInstitutionService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CareInstitutionControllerTest {

    private List<CareinstitutionEntity> careinstitutionEntities = new ArrayList<>();
    private CareInstitutionService careInstitutionService = mock(CareInstitutionService.class);
    private CareinstitutionEntity careinstitutionEntity = new CareinstitutionEntity();

    @Test
    public void getAllCareInstitutionsTest() {
        when(careInstitutionService.getAllCareInstitutions()).thenReturn(careinstitutionEntities);
    }

    //
//    @Test
//    public void getCareInstitutionTest() throws SQLException {
//        when(careInstitutionService.findById(1)).thenReturn(careInstitutionA);
//        ICareInstitution testCareInstitution = careInstitutionController.getCareInstitutionId("1");
//        assertEquals("instellingA", testCareInstitution.getName());
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
//
//    @Test
//    public void addCareInstitutionTest() throws SQLException{
//        ICareInstitution careInstitutionZ = new ICareInstitution(6, "instellingZ");
//        careInstitutionController.addCareInstitution(careInstitutionZ);
//        when(careInstitutionService.findById(6)).thenReturn(careInstitutionZ);
//        ICareInstitution testCareInstitution = careInstitutionController.getCareInstitutionId("6");
//        assertEquals("instellingZ", testCareInstitution.getName());
//    }
}
