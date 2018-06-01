package org.han.ica.oose.boterbloem.service.serviceimplementation;


import org.han.ica.oose.boterbloem.domain.domainobjects.Ratings;
import org.han.ica.oose.boterbloem.domain.domainmappers.RatingsMapper;
import org.han.ica.oose.boterbloem.service.IRatingsService;


import java.util.List;

public class RatingsService implements IRatingsService {

    private RatingsMapper ratingsMapper = new RatingsMapper();

    public RatingsService() {
        //Empty constructor
    }

    public List<Ratings> getAllRatings() {
        return ratingsMapper.allRatings();
    }

    @Override
    public List <Ratings> getAllRatingsFromASpecificDriverById(int id) {
        return ratingsMapper.getAllRatingsFromASpecificDriver(id);

    }

    @Override
    public List<List<Ratings>> getAllRatingsFromASpecificCareInstitution(int careInstitutionId) {
        return ratingsMapper.getAllRatingsFromASpecificCareInstitution(careInstitutionId);
    }

}