package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntityPK;

import java.util.List;

public interface IDrivercarDAO extends IGenericDAO<DrivercarEntity> {
    DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK);
    DrivercarEntity findCarById(int id);
    List<DrivercarEntity> drivercarEntityListByDriverId(int driverId);

}
