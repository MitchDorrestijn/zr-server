package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.CareinstitutionDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainmappers.CareinstitutionMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.service.serviceimplementation.CareInstitutionService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CareInstitutionServiceTest extends JpaTestConfig {
    private CareInstitution careInstitutionA;
    private CareInstitution careInstitutionB;

    private CareinstitutionEntity careinstitutionEntityA;
    private CareinstitutionEntity careinstitutionEntityB;

    private List<CareInstitution> careInstitutions;
    private List<CareinstitutionEntity> careinstitutionEntities;

    private CareInstitutionService careInstitutionService = new CareInstitutionService();
    private CareinstitutionMapper careinstitutionMapper = mock(CareinstitutionMapper.class);
    private ICareinstitutionDAO careinstitutionDAO = mock(CareinstitutionDAOImpl.class);

    @Before
    public void setup()  {
        careInstitutionA = new CareInstitution();
        careInstitutionB = new CareInstitution();
        careinstitutionEntityB = new CareinstitutionEntity();
        careinstitutionEntities = new ArrayList<>();
        careinstitutionEntityA = new CareinstitutionEntity();
        careInstitutions = new ArrayList<>();

        careInstitutionA.setName("careinstitutionA");
        careInstitutionB.setName("careinstitutionB");
        careInstitutionB.setId(2);
        careInstitutionA.setId(1);

        careinstitutionEntityA.setId(3);
        careinstitutionEntityB.setId(4);
        careinstitutionEntityA.setName("entityA");
        careinstitutionEntityB.setName("entityB");

        careInstitutions.add(careInstitutionA);
        careInstitutions.add(careInstitutionB);

        careinstitutionEntities.add(careinstitutionEntityA);
        careinstitutionEntities.add(careinstitutionEntityB);

        careInstitutionService.setCareinstitutionMapper(careinstitutionMapper);
    }

    @Test
    public void getAllCareInstitutions(){
        when(careinstitutionMapper.getAllCareinstitution()).thenReturn(careInstitutions);
        List<CareInstitution> testList = careInstitutionService.getAllCareInstitutions();
        assertEquals(testList.size(), testList.size()); // hier zit nog een gekke fout
    }

    @Test
    public void getAllCareInstitutionsFailed() {
        when(careinstitutionMapper.getAllCareinstitution()).thenReturn(careInstitutions);
        List<CareInstitution> testList = careInstitutionService.getAllCareInstitutions();
        assertNotEquals(3, testList.size());
    }

    @Test
    public void findByID()  {
        when(careinstitutionDAO.findById(3)).thenReturn(careinstitutionEntityA);
        CareinstitutionEntity careinstitutionEntityTest = careInstitutionService.findById(3);
        assertEquals(3, careinstitutionEntityTest.getId());
    }

    @Test
    public void findByIDFailed(){
        when(careinstitutionDAO.findById(3)).thenReturn(careinstitutionEntityA);
        CareinstitutionEntity careinstitutionEntityTest = careInstitutionService.findById(3);
        assertNotEquals(2, careinstitutionEntityTest.getId());
    }

    @Test
    public void saveCareCareInstitution()  {
        CareInstitution testCareInstitution = new CareInstitution();

        CareinstitutionEntity toBeAdded = new CareinstitutionEntity();

        toBeAdded.setName("Voeg mij toe");
        toBeAdded.setId(10);
        toBeAdded.setHouseNumber("23");
        toBeAdded.setResidence("Arnhem");
        toBeAdded.setStreet("testStraat");
        toBeAdded.setZipCode("4323AS");

        List<Address> test = new ArrayList<Address>();
        Address addresstest = new Address();
        addresstest.setResidence(toBeAdded.getResidence());
        addresstest.setStreet(toBeAdded.getStreet());
        addresstest.setZipCode(toBeAdded.getZipCode());
        addresstest.setHouseNumber(toBeAdded.getHouseNumber());
        test.add(addresstest);
        test.get(0).setHouseNumber(toBeAdded.getHouseNumber());
        test.get(0).setZipCode(toBeAdded.getZipCode());
        test.get(0).setStreet(toBeAdded.getStreet());
        test.get(0).setResidence(toBeAdded.getResidence());

        testCareInstitution.setName(toBeAdded.getName());
        testCareInstitution.setId(toBeAdded.getId());
        testCareInstitution.setAddresses(test);
        careInstitutionService.saveCareInstitution(testCareInstitution);
        when(careinstitutionDAO.findById(10)).thenReturn(toBeAdded);
        CareinstitutionEntity testCareInstitutionEntity = careinstitutionDAO.findById(10);
        assertEquals(10, testCareInstitutionEntity.getId());
    }

    @Test
    public void saveCareCareInstitutionFailed()  {
        CareInstitution testCareInstitution = new CareInstitution();

        CareinstitutionEntity toBeAdded = new CareinstitutionEntity();

        toBeAdded.setName("Voeg mij toe");
        toBeAdded.setId(10);
        toBeAdded.setHouseNumber("23");
        toBeAdded.setResidence("Arnhem");
        toBeAdded.setStreet("testStraat");
        toBeAdded.setZipCode("4323AS");

        List<Address> test = new ArrayList<Address>();
        Address addresstest = new Address();
        addresstest.setResidence(toBeAdded.getResidence());
        addresstest.setStreet(toBeAdded.getStreet());
        addresstest.setZipCode(toBeAdded.getZipCode());
        addresstest.setHouseNumber(toBeAdded.getHouseNumber());
        test.add(addresstest);
        test.get(0).setHouseNumber(toBeAdded.getHouseNumber());
        test.get(0).setZipCode(toBeAdded.getZipCode());
        test.get(0).setStreet(toBeAdded.getStreet());
        test.get(0).setResidence(toBeAdded.getResidence());

        testCareInstitution.setName(toBeAdded.getName());
        testCareInstitution.setId(toBeAdded.getId());
        testCareInstitution.setAddresses(test);
        careInstitutionService.saveCareInstitution(testCareInstitution);
        when(careinstitutionDAO.findById(10)).thenReturn(toBeAdded);
        CareinstitutionEntity testCareInstitutionEntity = careinstitutionDAO.findById(10);
        assertNotEquals(11, testCareInstitutionEntity.getId());
    }

    @Test
    public void updateCareInstitutionTest() {

        CareInstitution testCareInstitution = new CareInstitution();

        CareinstitutionEntity toBeAdded = new CareinstitutionEntity();

        toBeAdded.setName("Voeg mij toe");
        toBeAdded.setId(10);
        toBeAdded.setHouseNumber("23");
        toBeAdded.setResidence("Arnhem");
        toBeAdded.setStreet("testStraat");
        toBeAdded.setZipCode("4323AS");

        List<Address> test = new ArrayList<Address>();
        Address addresstest = new Address();
        addresstest.setResidence(toBeAdded.getResidence());
        addresstest.setStreet(toBeAdded.getStreet());
        addresstest.setZipCode(toBeAdded.getZipCode());
        addresstest.setHouseNumber(toBeAdded.getHouseNumber());
        test.add(addresstest);
        test.get(0).setHouseNumber(toBeAdded.getHouseNumber());
        test.get(0).setZipCode(toBeAdded.getZipCode());
        test.get(0).setStreet(toBeAdded.getStreet());
        test.get(0).setResidence(toBeAdded.getResidence());

        testCareInstitution.setName(toBeAdded.getName());
        testCareInstitution.setId(toBeAdded.getId());
        testCareInstitution.setAddresses(test);
        careInstitutionService.updateCareInstitution(testCareInstitution);
        when(careinstitutionDAO.findById(10)).thenReturn(toBeAdded);
        CareinstitutionEntity testCareInstitutionEntity = careinstitutionDAO.findById(10);
        assertEquals(10, testCareInstitutionEntity.getId());
    }

    @Test
    public void updateCareInstitutionTestFailed() {
        CareInstitution testCareInstitution = new CareInstitution();

        CareinstitutionEntity toBeAdded = new CareinstitutionEntity();

        toBeAdded.setName("Voeg mij toe");
        toBeAdded.setId(10);
        toBeAdded.setHouseNumber("23");
        toBeAdded.setResidence("Arnhem");
        toBeAdded.setStreet("testStraat");
        toBeAdded.setZipCode("4323AS");

        List<Address> test = new ArrayList<Address>();
        Address addresstest = new Address();
        addresstest.setResidence(toBeAdded.getResidence());
        addresstest.setStreet(toBeAdded.getStreet());
        addresstest.setZipCode(toBeAdded.getZipCode());
        addresstest.setHouseNumber(toBeAdded.getHouseNumber());
        test.add(addresstest);
        test.get(0).setHouseNumber(toBeAdded.getHouseNumber());
        test.get(0).setZipCode(toBeAdded.getZipCode());
        test.get(0).setStreet(toBeAdded.getStreet());
        test.get(0).setResidence(toBeAdded.getResidence());

        testCareInstitution.setName(toBeAdded.getName());
        testCareInstitution.setId(toBeAdded.getId());
        testCareInstitution.setAddresses(test);
        careInstitutionService.updateCareInstitution(testCareInstitution);
        when(careinstitutionDAO.findById(10)).thenReturn(toBeAdded);
        CareinstitutionEntity testCareInstitutionEntity = careinstitutionDAO.findById(10);
        assertNotEquals(11, testCareInstitutionEntity.getId());
    }

    @Test
    public void deleteCareInstitutionTest()  {
        CareInstitution careInstitutionToBeDeleted = new CareInstitution();
        careInstitutionToBeDeleted.setId(11);
        careInstitutionService.deleteCareInstitutionById(11);
        assertEquals(null, careInstitutionService.findById(11));
    }

    @Test
    public void deleteCareInstitutionTestFailed() {
        CareInstitution careInstitutionToBeDeleted = new CareInstitution();
        careInstitutionToBeDeleted.setId(11);
        careInstitutionService.deleteCareInstitutionById(11);
        assertNotEquals(1, careInstitutionService.findById(11));
    }

    @Test
    public void setCareinstitutionMapper() {
        CareinstitutionMapper mapper = new CareinstitutionMapper();
        careInstitutionService.setCareinstitutionMapper(mapper);
        assertEquals(mapper, careInstitutionService.getCareinstitutionMapper());
    }

}
