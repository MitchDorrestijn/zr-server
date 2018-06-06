package org.han.ica.oose.boterbloem.service.serviceimplementation;


import org.han.ica.oose.boterbloem.domain.domainobjects.Rating;
import org.han.ica.oose.boterbloem.domain.domainmappers.RatingsMapper;
import org.han.ica.oose.boterbloem.service.IRatingsService;


import java.util.List;

public class RatingsService implements IRatingsService {

    private RatingsMapper ratingsMapper = new RatingsMapper();

    public RatingsService() {
        //Empty constructor
    }

    public List<Rating> getAllRatings() {
        return ratingsMapper.allRatings();
    }

    @Override
    public List <Rating> getAllRatingsFromASpecificDriverById(int id) {
        return ratingsMapper.getAllRatingsFromASpecificDriver(id);

    }

    @Override
    public List<List<Rating>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId) {
        return ratingsMapper.getAllRatingsFromASpecificCareInstitution(careInstitutionId);
    }

}