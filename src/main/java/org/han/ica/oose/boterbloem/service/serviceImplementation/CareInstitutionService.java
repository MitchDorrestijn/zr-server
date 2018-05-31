package org.han.ica.oose.boterbloem.service.serviceImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation.CareinstitutionDAOImpl;

import org.han.ica.oose.boterbloem.domain.domainObjects.CareInstitution;
import org.han.ica.oose.boterbloem.dataAccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainMappers.CareinstitutionMapper;
import org.han.ica.oose.boterbloem.service.ICareInstitutionService;

import java.util.List;

public class CareInstitutionService implements ICareInstitutionService {

    private ICareinstitutionDAO careinstitutionDAO = new CareinstitutionDAOImpl();
    private CareinstitutionMapper careinstitutionMapper = new CareinstitutionMapper();

    public CareInstitutionService() {
        // Empty constructor
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CareinstitutionEntity findById(int id) {
        return careinstitutionDAO.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List <CareInstitution> getAllCareInstitutions() {
        return careinstitutionMapper.getAllCareinstitution();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveCareInstitution(CareInstitution careInstitution) {
        careinstitutionMapper.saveCareInstitution(careInstitution);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCareInstitution(CareInstitution careInstitution) {
        careinstitutionMapper.update(careInstitution);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCareInstitutionById(int id) {
        CareinstitutionEntity careinstitutionEntity = this.findById(id);
        careinstitutionDAO.remove(careinstitutionEntity);
    }

}