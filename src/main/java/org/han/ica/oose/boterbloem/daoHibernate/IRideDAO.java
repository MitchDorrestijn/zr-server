package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.RideEntity;

public interface IRideDAO extends IGenericDAO<RideEntity> {

     int rideCountById(int id);
}
