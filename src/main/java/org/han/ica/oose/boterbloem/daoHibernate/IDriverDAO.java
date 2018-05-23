package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.DriverEntity;

public interface IDriverDAO extends IGenericDAO<DriverEntity> {
    void deleteDriver(int driverId);
}
