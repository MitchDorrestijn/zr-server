package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.entity.RatingsEntity;
import org.han.ica.oose.boterbloem.service.projection.RatingsDisplay;

import java.util.List;

public interface IRatingsService {
    /**
     * @return A list of all ratings from the database
     */
    public List<RatingsDisplay> getAllRatings();
}
