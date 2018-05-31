package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntityPK;

public interface IDrivercarDAO extends IGenericDAO<DrivercarEntity> {
    public DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK);
    DrivercarEntity findCarById(int id);


}
