package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;

import java.util.List;

public interface ICareInstitutionService {
    /**
     * GET CareInstitution by Id
     * @param id of CareInstitution
     * @return CareInstitution
     */
    CareinstitutionEntity findById(int id);

    /**
     * GET all CareInstitutions
     * @return list of CareInstitutions
     */
    List <CareInstitution> getAllCareInstitutions();

    /**
     * CREATE new CareInstitution
     * @param careInstitution =  new CareInstitution
     */
    void saveCareInstitution(CareInstitution careInstitution);

    /**
     * UPDATE CareInstitution
     * @param careInstitution = CareInstitution
     */
    void updateCareInstitution(CareInstitution careInstitution);

    /**
     * DELETE CareInstitution by Id
     * @param id of CareInstitution
     */
    void deleteCareInstitutionById(int id);
}
