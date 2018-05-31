package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;

public interface IDriverDAO extends IGenericDAO<DriverEntity> {
    int latestId();
    void deleteDriver(int driverId);
}
