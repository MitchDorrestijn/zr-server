package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dataAccess.entities.LimitationEntity;

import java.util.List;

public interface ILimitationService {
    /**
     * Retrieves a specific limitation from the database
     * @param name The name of the limitation
     * @return the corresponding limitation
     */
    LimitationEntity getLimitationByName(String name);

    /**
     * Retrieves all limitations from the database
     * @return list of Limitations
     */
    List<LimitationEntity> getAllLimitations();

    /**
     * Adds a new limitation to the database
     * @param limitationEntity the limitation that will be added
     */
    void addLimitation(LimitationEntity limitationEntity);

    /**
     * Updates an exisiting limitation with a new name
     * @param limitationEntity = Limitation
     */
    void updateLimitation(LimitationEntity limitationEntity);

    /**
     * Deletes an existing limitation from the database
     * @param name of Limitation
     */
    void deleteLimitation(String name);
}
