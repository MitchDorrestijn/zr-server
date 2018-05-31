package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataAccess.entities.DrivercarEntityPK;

public interface IDrivercarDAO extends IGenericDAO<DrivercarEntity> {
    public DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK);
    DrivercarEntity findCarById(int id);


}
