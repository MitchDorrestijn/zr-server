package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntityPK;

public interface IDrivercarDAO extends IGenericDAO<DrivercarEntity> {
    public DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK);
    DrivercarEntity findCarById(int id);


}
