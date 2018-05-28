//package org.han.ica.oose.boterbloem.service;
//
//import org.han.ica.oose.boterbloem.dao.CareInstitutionDAO;
//import org.han.ica.oose.boterbloem.domain.CareInstitution;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CareInstitutionServiceTest {
//
//
//    private CareInstitution careInstitutionA = new CareInstitution(1, "instellingA");
//    private CareInstitution careInstitutionB = new CareInstitution(2, "instellingB");
//    private CareInstitution careInstitutionC = new CareInstitution(3, "instellingC");
//    private CareInstitution careInstitutionD = new CareInstitution(4, "instellingD");
//    private CareInstitution careInstitutionE = new CareInstitution(5, "instellingE");
//
//    private List<CareInstitution> careInstitutions = new ArrayList<>();
//
//    private CareInstitutionService careInstitutionService = new CareInstitutionService();
//    private CareInstitutionDAO careInstitutionDAO = mock(CareInstitutionDAO.class);
//
//
//    @Before
//    public void setup() throws SQLException {
//
//
//        careInstitutions.add(careInstitutionA);
//        careInstitutions.add(careInstitutionB);
//        careInstitutions.add(careInstitutionC);
//        careInstitutions.add(careInstitutionD);
//        careInstitutions.add(careInstitutionE);
//        careInstitutionService.careInstitutionDAO = careInstitutionDAO;
//    }
//
//
//    @Test
//    public void getAllCareInstitutions() throws SQLException {
//        when(careInstitutionDAO.getAllCareInstitutions()).thenReturn(careInstitutions);
//        List<CareInstitution> testCareInstitutions = careInstitutionService.getAllCareInstitutions();
//        assertEquals(5, testCareInstitutions.size());
//    }
//
//    @Test
//    public void whenCreateNoException() {
//        // When
//        careInstitutionService.saveCareInstitution(careInstitutionA);
//    }
//
//    @Test
//    public void whenCreateIsTriggered_thenEntityIsCreated() {
//        // When
//
//        this.careInstitutionService.saveCareInstitution(careInstitutionA);
//
//        // Then
//        ArgumentCaptor<CareInstitution> argument = ArgumentCaptor.forClass(CareInstitution.class);
//        verify(careInstitutionDAO).create(argument.capture());
//        assertEquals(careInstitutionA.getName(), argument.getValue().getName());
//    }
//
//    @Test
//    public void whenUpdateNoException() {
//        careInstitutionService.updateCareInstitution(careInstitutionA);
//    }
//
//    @Test
//    public void whenUpdateIsTriggered_ThenEntityUpdated() {
//        this.careInstitutionService.updateCareInstitution(careInstitutionA);
//
//        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
//        ArgumentCaptor<Integer> argument2 = ArgumentCaptor.forClass(Integer.class);
//        verify(careInstitutionDAO).updateCareInstitution(argument2.capture(), argument.capture());
//        assertEquals(careInstitutionA.getName(), argument.getValue().toString());
//    }
//
//    @Test
//    public void findByIdTest() {
//        when(careInstitutionDAO.getByID(1)).thenReturn(careInstitutionA);
//        CareInstitution careInstitution = careInstitutionService.findById(1);
//
//        assertEquals(careInstitutionA.getName(), careInstitution.getName());
//
//    }
//
//}
//
