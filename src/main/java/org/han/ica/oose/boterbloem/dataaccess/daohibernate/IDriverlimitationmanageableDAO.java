package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

import java.util.List;

public interface IDriverlimitationmanageableDAO extends IGenericDAO<DriverlimitationmanageableEntity> {


    List<String> getByDriverId(int id);
    void updateDriverLimitations(List<String> limitations, int driverId);
}
