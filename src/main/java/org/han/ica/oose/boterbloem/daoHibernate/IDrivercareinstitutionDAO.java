package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.DrivercareinstitutionEntity;
import org.han.ica.oose.boterbloem.entity.DrivercareinstitutionEntityPK;

public interface IDrivercareinstitutionDAO extends IGenericDAO<DrivercareinstitutionEntity> {

    DrivercareinstitutionEntity find(DrivercareinstitutionEntityPK drivercareinstitutionEntityPK);
}
