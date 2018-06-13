package org.han.ica.oose.boterbloem.domain.domainmappers;


import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.CareinstitutionDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.service.CareInstitutionServiceTest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class CareInstitutionMapperTest extends JpaTestConfig {

    private CareInstitution careInstitutionA = new CareInstitution();
    private CareInstitution careInstitutionB = new CareInstitution();

    private CareInstitutionServiceTest careInstitutionServiceTest = new CareInstitutionServiceTest();

    private CareinstitutionEntity careinstitutionEntityA = new CareinstitutionEntity();
    private CareinstitutionEntity careinstitutionEntityB = new CareinstitutionEntity();

    private List<CareInstitution> careInstitutions = new ArrayList<>();
    private List<CareinstitutionEntity> careinstitutionEntities = new ArrayList<>();

    private CareinstitutionMapper careinstitutionMapper = new CareinstitutionMapper();
    private ICareinstitutionDAO careinstitutionDAO = new CareinstitutionDAOImpl();

    @Before
    public void setup()  {
        careinstitutionEntities.add(careinstitutionEntityA);
        careinstitutionEntities.add(careinstitutionEntityB);
        careinstitutionDAO.setEntityManager(em);
        careinstitutionMapper.setCareinstitutionDAO(careinstitutionDAO);

    }

    @Test
    public void getAllCareInstitutionTest() {

        List<CareInstitution> testList = careinstitutionMapper.getAllCareinstitution();
        System.out.println(testList.size());
        assertEquals(5,testList.size());
    }

    @Test
    public void getAllCareInstitutionTestFailed()  {
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
