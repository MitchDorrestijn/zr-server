package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.entity.LimitationEntity;

import java.util.List;

public interface ILimitationService {

    /**
     * Retrieves all limitations from the database
     * @return
     */
    List<LimitationEntity> getAll();

    /**
     * Retrieves a specific limitation from the database
     * @param name The name of the limitation
     * @return the corresponding limitation
     */
    LimitationEntity getByName(String name);
}
