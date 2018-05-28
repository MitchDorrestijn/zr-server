package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.DriverlimitationmanageableEntity;

import java.util.ArrayList;
import java.util.List;

public interface IDriverlimitationmanageableDAO extends IGenericDAO<DriverlimitationmanageableEntity> {


    List<String> getByDriverId(int id);
    void updateDriverLimitations(ArrayList<String> limitations, int driverId);
}
