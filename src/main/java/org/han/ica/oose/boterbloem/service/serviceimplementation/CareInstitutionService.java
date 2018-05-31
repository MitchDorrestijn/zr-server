package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.CareinstitutionDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.domain.domainmappers.CareinstitutionMapper;
import org.han.ica.oose.boterbloem.service.ICareInstitutionService;

import java.util.List;


public class CareInstitutionService implements ICareInstitutionService {


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
        careinstitutionMapper.update(careInstitution);
    }


    /**
     * @param careInstitution that's going to be added to the database
     */
    public void saveCareInstitution(CareInstitution careInstitution) {
        careinstitutionMapper.saveCareInstitution(careInstitution);
    }

    /**
     * @return List of all CareInstitutions
     */
    public List<CareInstitution> getAllCareInstitutions() {
        return careinstitutionMapper.getAllCareinstitution();
    }

    /**
     * @param id
     */
    public void deleteCareInstitutionById(int id) {
        CareinstitutionEntity careinstitutionEntity = this.findById(id);
        careinstitutionDAO.remove(careinstitutionEntity);
    }
}