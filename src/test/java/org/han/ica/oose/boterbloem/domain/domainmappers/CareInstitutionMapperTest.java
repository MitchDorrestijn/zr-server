package org.han.ica.oose.boterbloem.domain.domainmappers;


import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.CareinstitutionDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainmappers.CareinstitutionMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.service.CareInstitutionServiceTest;
import org.han.ica.oose.boterbloem.service.serviceimplementation.CareInstitutionService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
public class CareInstitutionMapperTest extends CareInstitutionServiceTest {

    private CareInstitution careInstitutionA = new CareInstitution();
    private CareInstitution careInstitutionB = new CareInstitution();

    private CareInstitutionServiceTest careInstitutionServiceTest = new CareInstitutionServiceTest();

    private CareinstitutionEntity careinstitutionEntityA = new CareinstitutionEntity();
    private CareinstitutionEntity careinstitutionEntityB = new CareinstitutionEntity();

    private List<CareInstitution> careInstitutions = new ArrayList<>();
    private List<CareinstitutionEntity> careinstitutionEntities = new ArrayList<>();

    private CareinstitutionMapper careinstitutionMapper = new CareinstitutionMapper();
    private ICareinstitutionDAO careinstitutionDAO = mock(CareinstitutionDAOImpl.class);

    @Before
    public void setup() throws SQLException {
        careInstitutionServiceTest.setup();
        careinstitutionEntities.add(careinstitutionEntityA);
        careinstitutionEntities.add(careinstitutionEntityB);
        careinstitutionMapper.setCareinstitutionDAO(careinstitutionDAO);
    }

    @Test
    public void getAllCareInstitutionTest() throws SQLException {
        when(careinstitutionDAO.findAll()).thenReturn(careinstitutionEntities);
        careinstitutionMapper.getAllCareinstitution();
        List<CareInstitution> testList = careinstitutionMapper.getAllCareinstitution();
        assertEquals(2,testList.size());
    }

    @Test
    public void getAllCareInstitutionTestFailed() throws SQLException {
        when(careinstitutionDAO.findAll()).thenReturn(careinstitutionEntities);
        careinstitutionMapper.getAllCareinstitution();
        List<CareInstitution> testList = careinstitutionMapper.getAllCareinstitution();
        assertNotEquals(200,testList.size());
    }


/*     @Test
          List<Address> address = careInstitution.getAddresses();
        CareinstitutionEntity careinstitutionEntity = new CareinstitutionEntity();
        careinstitutionEntity.setId(careInstitution.getId());
        careinstitutionEntity.setName(careInstitution.getName());
        careinstitutionEntity.setResidence(address.get(0).getResidence());
        careinstitutionEntity.setZipCode(address.get(0).getZipCode());
        careinstitutionEntity.setHouseNumber(address.get(0).getHouseNumber());
        careinstitutionEntity.setStreet(address.get(0).getStreet());
        careinstitutionDAO.update(careinstitutionEntity);
  */
}
