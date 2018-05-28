package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.CareinstitutionDAOImpl;

import org.han.ica.oose.boterbloem.daoHibernate.ICareinstitutionDAO;

import org.han.ica.oose.boterbloem.entity.CareinstitutionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

public class CareInstitutionService implements ICareInstitutionService {
    private static final Logger LOGGER = Logger.getLogger(DriverService.class.getName());

    private ICareinstitutionDAO careinstitutionDAO = new CareinstitutionDAOImpl();

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
    public void updateCareInstitution(CareinstitutionEntity careInstitution) {

        //The posted name should be put here
        careinstitutionDAO.update(careInstitution);
    }


    /**
     * @param careInstitution that's going to be added to the database
     */
    public void saveCareInstitution(CareinstitutionEntity careInstitution) {
        careinstitutionDAO.add(careInstitution);
    }

    /**
     * @return List of all CareInstitutions
     */
    public List<CareinstitutionEntity> getAllCareInstitutions() {
        return careinstitutionDAO.findAll();
    }

    /**
     * @param int id
     */

    public void deleteCareInstitutionById(int id) {
        CareinstitutionEntity careinstitutionEntity = this.findById(id);
        careinstitutionDAO.remove(careinstitutionEntity);
    }
}