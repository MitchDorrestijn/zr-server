package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntityPK;

import java.util.List;

public interface IDriverDAO extends IGenericDAO<DriverEntity> {
    int latestId();
    void deleteDriver(int driverId);

    /**
     * @param id id of the careinstitution
     * @return a list of drivers from a specific care institution
     */
    List<DriverEntity> getByCareInstitutionId(int id);
}
