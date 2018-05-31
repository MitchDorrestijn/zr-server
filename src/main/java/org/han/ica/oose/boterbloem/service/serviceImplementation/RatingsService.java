package org.han.ica.oose.boterbloem.service.serviceImplementation;

import org.han.ica.oose.boterbloem.domain.domainObjects.Ratings;
import org.han.ica.oose.boterbloem.domain.domainMappers.RatingsMapper;
import org.han.ica.oose.boterbloem.service.IRatingsService;

import java.util.List;

public class RatingsService implements IRatingsService {

    private RatingsMapper ratingsMapper = new RatingsMapper();

    public RatingsService() {
        //Empty constructor
    }

    /**
     * {@inheritDoc}
     */
    public List<Ratings> getAllRatings() {
        return ratingsMapper.getAllRatings();
    }

    /**
     * {@inheritDoc}
     */
    public List<Ratings> getAllRatingsFromASpecificDriverById(int id) {
        return ratingsMapper.getAllRatingsFromASpecificDriverById(id);
    }
}