package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.DriverlimitationmanageableEntity;

import java.util.ArrayList;
import java.util.List;

public interface IDriverlimitationmanageableDAO extends IGenericDAO<DriverlimitationmanageableEntity> {


    List<String> getByDriverId(int id);
    void updateDriverLimitations(ArrayList<String> limitations, int driverId);
}
