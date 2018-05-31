package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverlimitationmanageableEntity;

import java.util.ArrayList;
import java.util.List;

public interface IDriverlimitationmanageableDAO extends IGenericDAO<DriverlimitationmanageableEntity> {


    List<String> getByDriverId(int id);
    void updateDriverLimitations(ArrayList<String> limitations, int driverId);
}
