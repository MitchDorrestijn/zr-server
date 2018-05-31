//package org.han.ica.oose.boterbloem.controller;
//
//import org.han.ica.oose.boterbloem.domain.domainImplementation.ICareInstitution;
//import org.han.ica.oose.boterbloem.service.serviceImplementation.CareInstitutionService;
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
//    private ICareInstitution careInstitutionA = new ICareInstitution(1, "instellingA");
//    private ICareInstitution careInstitutionB = new ICareInstitution(2, "instellingB");
//    private ICareInstitution careInstitutionC = new ICareInstitution(3, "instellingC");
//    private ICareInstitution careInstitutionD = new ICareInstitution(4, "instellingD");
//    private ICareInstitution careInstitutionE = new ICareInstitution(5, "instellingE");
//
//    private List<ICareInstitution> careInstitutions = new ArrayList<>();
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
//        List<ICareInstitution> testCareInstitutions = careInstitutionController.getAllCareInstitutions();
//        assertEquals(5, testCareInstitutions.size());
//    }
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
//}
