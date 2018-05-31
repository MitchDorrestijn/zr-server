package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.RideEntity;

import java.util.List;

public interface IRideDAO extends IGenericDAO <RideEntity> {

    int rideCountById(int id);

    int totalRideClient(int id);

    List <RideEntity> getByClient(int id);

    List <RideEntity> getByDriver(int id);

    float totalEarned(int id);
}
