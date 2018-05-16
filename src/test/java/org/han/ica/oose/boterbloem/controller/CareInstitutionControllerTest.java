//package org.han.ica.oose.boterbloem.controller;
//
//import org.han.ica.oose.boterbloem.domain.CareInstitution;
//import org.han.ica.oose.boterbloem.service.CareInstitutionService;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CareInstitutionControllerTest {
//
//    private CareInstitution careInstitutionA = new CareInstitution(1, "instellingA");
//    private CareInstitution careInstitutionB = new CareInstitution(2, "instellingB");
//    private CareInstitution careInstitutionC = new CareInstitution(3, "instellingC");
//    private CareInstitution careInstitutionD = new CareInstitution(4, "instellingD");
//    private CareInstitution careInstitutionE = new CareInstitution(5, "instellingE");
//
//    private List<CareInstitution> careInstitutions = new ArrayList<>();
//
//    private CareInstitutionController careInstitutionController = new CareInstitutionController();
//    private CareInstitutionService careInstitutionService = mock(CareInstitutionService.class);
//
//
//    @Before
//    public void setup() {
//        careInstitutions.add(careInstitutionA);
//        careInstitutions.add(careInstitutionB);
//        careInstitutions.add(careInstitutionC);
//        careInstitutions.add(careInstitutionD);
//        careInstitutions.add(careInstitutionE);
//        careInstitutionController.careInstitutionService = careInstitutionService;
//    }
//
//
//    @Test
//    public void getAllCareInstitutionsTest() throws SQLException {
//        when(careInstitutionService.getAllCareInstitutions()).thenReturn(careInstitutions);
//        List<CareInstitution> testCareInstitutions = careInstitutionController.getAllCareInstitutions();
//        assertEquals(5, testCareInstitutions.size());
//    }
//
//    @Test
//    public void getCareInstitutionTest() throws SQLException {
//        when(careInstitutionService.findById(1)).thenReturn(careInstitutionA);
//        CareInstitution testCareInstitution = careInstitutionController.getCareInstitution("1");
//        assertEquals("instellingA", testCareInstitution.getName());
//    }
//
//
//    @Test
//    public void updateCareInstitutionTest() throws SQLException{
//        when(careInstitutionService.findById(1)).thenReturn(careInstitutionA);
//        CareInstitution testCareInstitution = careInstitutionController.getCareInstitution("1");
//        testCareInstitution.setName("new name");
//        careInstitutionController.updateCareInstitution(1, testCareInstitution);
//        assertEquals("new name", testCareInstitution.getName());
//    }
//
//    @Test
//    public void addCareInstitutionTest() throws SQLException{
//        CareInstitution careInstitutionZ = new CareInstitution(6, "instellingZ");
//        careInstitutionController.addCareInstitution(careInstitutionZ);
//        when(careInstitutionService.findById(6)).thenReturn(careInstitutionZ);
//        CareInstitution testCareInstitution = careInstitutionController.getCareInstitution("6");
//        assertEquals("instellingZ", testCareInstitution.getName());
//    }
//}
