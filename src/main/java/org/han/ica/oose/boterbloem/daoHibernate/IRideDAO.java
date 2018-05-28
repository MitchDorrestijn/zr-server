package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.RideEntity;

import java.util.List;

public interface IRideDAO extends IGenericDAO<RideEntity> {

    int rideCountById(int id);

    int totalRideClient(int id);

    List<RideEntity> getByClientId(int id);

    float totalEarned(int id);
}
