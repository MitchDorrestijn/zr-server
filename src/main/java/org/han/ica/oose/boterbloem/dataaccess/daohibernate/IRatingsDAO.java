package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.RatingsEntity;

import java.util.List;

public interface IRatingsDAO extends IGenericDAO<RatingsEntity> {

    /**
     * @param id the id from the driver
     * @return the average rating from the driver
     */
    public int getAvgRatings(int id);

    /**
     * @param driverId the id of the driver
     * @return a list of ratings from the driver
     */
    List<RatingsEntity> getByDriver(int driverId);

    /**
     * @param careInstitutionId the id of the careInstitution
     * @return a list of ratings of the drivers from a specific careInstitution
     */
    List<List<RatingsEntity>> getByCareInstitution(int careInstitutionId);
}
