package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.CareinstitutionDAOImpl;

import org.han.ica.oose.boterbloem.daoHibernate.ICareinstitutionDAO;

import org.han.ica.oose.boterbloem.domain.domainImplementation.CareInstitution;
import org.han.ica.oose.boterbloem.entity.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.mapper.CareinstitutionMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CareInstitutionService implements ICareInstitutionService {
    private static final Logger LOGGER = Logger.getLogger(DriverService.class.getName());

    private ICareinstitutionDAO careinstitutionDAO = new CareinstitutionDAOImpl();
    private CareinstitutionMapper careinstitutionMapper = new CareinstitutionMapper();
    public CareInstitutionService() {
        // Empty constructor
    }

    /**
     * Finds and returns a ICareInstitution using the given ID
     *
     * @param id ID of the ICareInstitution
     * @return The ICareInstitution that was found using the ID
     */
    public CareinstitutionEntity findById(int id) {
        return careinstitutionDAO.findById(id);
    }

    /**
     * @param careInstitution ICareInstitution that needs a update
     */
    public void updateCareInstitution(CareInstitution careInstitution) {

        //The posted name should be put here
        careinstitutionMapper.update(careInstitution);
    }


    /**
     * @param careInstitution that's going to be added to the database
     */
    public void saveCareInstitution(CareInstitution careInstitution) {
        //careinstitutionDAO.add(careInstitution);

        careinstitutionMapper.saveCareInstitution(careInstitution);
    }

    /**
     * @return List of all CareInstitutions
     */
    public List<CareInstitution> getAllCareInstitutions() {
        return careinstitutionMapper.getAllCareinstitution();
    }

    /**
     * @param int id
     */

    public void deleteCareInstitutionById(int id) {
        CareinstitutionEntity careinstitutionEntity = this.findById(id);
        careinstitutionDAO.remove(careinstitutionEntity);
    }
}