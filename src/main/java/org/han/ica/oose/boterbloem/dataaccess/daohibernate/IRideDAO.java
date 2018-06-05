package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;

import java.sql.Timestamp;
import java.util.List;

public interface IRideDAO extends IGenericDAO<RideEntity> {

    int rideCountById(int id);

    int totalRideClient(int id);

    List<RideEntity> getByClient(int id);

    List<RideEntity> getByDriver(int id);

    float totalEarned(int id);


    List<RideEntity> ridesWithCareinstitution(int careId);

    RideEntity getByClientAndDateTime(int clientId, Timestamp date);

}
