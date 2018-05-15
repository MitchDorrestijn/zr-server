package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.CareInstitution;

import java.sql.SQLException;

public interface ICareInstitutionService {

    CareInstitution findById(int id) throws SQLException;

    void updateCareInstitution(CareInstitution careInstitution) throws SQLException;


    void saveCareInstitution(CareInstitution careInstitution);

    void deleteCareInstitutionById(int careInstitution);
}
