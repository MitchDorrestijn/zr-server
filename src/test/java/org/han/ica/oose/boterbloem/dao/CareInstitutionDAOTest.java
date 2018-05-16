//package org.han.ica.oose.boterbloem.dao;
//
//import org.han.ica.oose.boterbloem.domain.CareInstitution;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CareInstitutionDAOTest {
//
//    private CareInstitutionDAO dao;
//
//    @Before
//    public void setup() throws Exception {
//        dao = new CareInstitutionDAO();
//        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/create_script.sql'").execute();
//        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/insert_script.sql'").execute();
//        dao.CONNECTION_DAO.getPreparedStatement("RUNSCRIPT FROM 'classpath:scripts/alter_script.sql'").execute();
//    }
//
//    @Test
//    public void hasConnection() {
//        assertTrue(dao.CONNECTION_DAO.hasConnection());
//    }
//
//    @Test
//    public void create() {
//        dao.create(new CareInstitution(6, "Prothese"));
//        CareInstitution temp = dao.getByID(6);
//        assertEquals(6, temp.getId());
//        assertEquals("Prothese", dao.getByName("Prothese").get(0).getName());
//        dao.deleteById(6);
//    }
//
//    @Test
//    public void getAllCareInstitutions() {
//        List<CareInstitution> careInstitutions = dao.getAllCareInstitutions();
//        assertEquals(1, careInstitutions.get(0).getId());
//        assertEquals("Reinearde", careInstitutions.get(0).getName());
//        assertNotEquals(1, careInstitutions.get(2).getId());
//        assertNotEquals("Cordaan", careInstitutions.get(0).getName());
//    }
//
//    @Test
//    public void getByID() {
//        CareInstitution careInstitution = dao.getByID(1);
//        assertEquals(1, careInstitution.getId());
//        assertNotEquals(2, careInstitution.getId());
//    }
//
//    @Test
//    public void getByName() {
//        List<CareInstitution> careInstitutions = dao.getByName("Reinearde");
//        assertEquals("Reinearde", careInstitutions.get(0).getName());
//        assertNotEquals("Cordaan", careInstitutions.get(0).getName());
//    }
//
//    @Test
//    public void updateCareInstitutionWithIdRegular(){
//        CareInstitution originalName = dao.getByID(1);
//        assertEquals("Reinearde", originalName.getName());
//    }
//
//    @Test
//    public void updateCareInstitutionWithIdFailed(){
//        CareInstitution originalName = dao.getByID(1);
//        assertNotEquals("Cordaan", originalName.getName());
//    }
//
//    @Test
//    public void deleteByID() {
//        dao.create(new CareInstitution(6, "Prothese"));
//        CareInstitution temp = dao.getByID(6);
//        assertEquals(6, temp.getId());
//        assertEquals("Prothese", temp.getName());
//
//        dao.deleteById(6);
//        assertNotEquals(6, dao.getByID(6));
//        assertTrue(dao.getByName("Prothese").size() == 0);
//    }
//
//    @Test
//    public void deleteByName(){
//        dao.create(new CareInstitution(6, "Prothese"));
//        CareInstitution temp = dao.getByID(6);
//        assertEquals(6, temp.getId());
//        assertEquals("Prothese", temp.getName());
//
//        dao.deleteByName("Prothese");
//        assertNotEquals(6, dao.getByID(6));
//        assertTrue(dao.getByName("Prothese").size() == 0);
//    }
//
//    @Test
//    public void updateCareInstitution() {
//        dao.create(new CareInstitution(6, "Prothese"));
//        CareInstitution temp = dao.getByID(6);
//        assertEquals(6, temp.getId());
//        assertEquals("Prothese", temp.getName());
//        dao.updateCareInstitution(6,"ProthesesVoorIedereen");
//        temp = dao.getByID(6);
//        assertEquals("ProthesesVoorIedereen", temp.getName());
//    }
//}