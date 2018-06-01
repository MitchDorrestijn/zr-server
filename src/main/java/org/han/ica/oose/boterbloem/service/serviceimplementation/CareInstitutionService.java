package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.service.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.domain.domainobjects.*;
import org.han.ica.oose.boterbloem.domain.domainmappers.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;

import java.util.*;

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