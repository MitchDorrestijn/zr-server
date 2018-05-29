package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;

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
}
