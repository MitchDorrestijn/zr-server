package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.CareInstitutionDAO;
import org.han.ica.oose.boterbloem.domain.CareInstitution;

import java.util.List;

public class CareInstitutionService implements ICareInstitutionService {

    CareInstitutionDAO careInstitutionDAO = new CareInstitutionDAO();

    public CareInstitutionService() {
        // Empty constructor
    }

    /**
     * Finds and returns a CareInstitution using the given ID
     *
     * @param id ID of the CareInstitution
     * @return The CareInstitution that was found using the ID
     */
    public CareInstitution findById(int id) {
        return (careInstitutionDAO.getByID(id));
    }

    /**
     * @param careInstitution CareInstitution that needs a update
     */
    public void updateCareInstitution(CareInstitution careInstitution) {

        //The posted name should be put here
        careInstitutionDAO.updateCareInstitution(careInstitution.getId(), careInstitution.getName());
    }


    /**
     * @param careInstitution that's going to be added to the database
     */
    public void saveCareInstitution(CareInstitution careInstitution) {
        careInstitutionDAO.create(careInstitution);
    }

    /**
     * @return List of all CareInstitutions
     */
    public List<CareInstitution> getAllCareInstitutions() {
        return careInstitutionDAO.getAllCareInstitutions();
    }

    /**
     * @param careInstitution CareInstitution
     */

    public void deleteCareInstitutionById(int careInstitution) {
        careInstitutionDAO.deleteById(careInstitution);
    }
}