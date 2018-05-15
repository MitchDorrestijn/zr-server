package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.CareInstitution;

import java.util.List;

/**
 * Interface for handling the CareInstitutionDAO
 */
public interface ICareInstitutionDAO {
    /**
     * Creates a new CareInstitution and adds it to the database
     *
     * @param careInstitution the CareInstitution that will be added
     */
    void create(CareInstitution careInstitution);

    /**
     * Requests a list of all current CareInstitution from the database
     *
     * @return The list of CareInstitution
     */
    List<CareInstitution> getAllCareInstitutions();

    /**
     * Reqeusts a specific CareInstitution by id from the database
     *
     * @param id The id related to the CareInstitution to be requested
     * @return The requested CareInstitution
     */
    CareInstitution getByID(int id);

    /**
     * Requests a specific CareInstitution by name from the database
     *
     * @param name The name related to the CareInstitution to be requested
     * @return The requested CareInstitution
     */
    List<CareInstitution> getByName(String name);

    /**
     * Deletes a CareInstitution with a given id from the database
     *
     * @param id The id related to the CareInstitution to be deleted
     */
    void deleteById(int id);

    /**
     * Deletes one or multiple CareInstitution with a given name from the database
     *
     * @param name
     */
    void deleteByName(String name);

    /**
     * Updates the CareInstitution with given values using the ID as reference
     *
     * @param id      ID of the CareInstitution
     * @param newName The new name
     */
    void updateCareInstitution(int id, String newName);

}


