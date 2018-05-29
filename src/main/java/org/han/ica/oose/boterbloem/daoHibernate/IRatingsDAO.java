package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;

import java.util.List;

public interface IRatingsDAO extends IGenericDAO<RatingsEntity> {
    public int getAvgRatings(int id);
    List<RatingsEntity> getByDriver(int driverId);
}
