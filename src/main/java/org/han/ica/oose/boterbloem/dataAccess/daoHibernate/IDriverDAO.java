package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.DriverEntity;

public interface IDriverDAO extends IGenericDAO<DriverEntity> {
    int latestId();
    void deleteDriver(int driverId);
}
