package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.entity.LimitationEntity;

import java.util.List;

public interface ILimitationService {

    /**
     * Retrieves all limitations from the database
     * @return
     */
    List<LimitationEntity> getAll();
}
