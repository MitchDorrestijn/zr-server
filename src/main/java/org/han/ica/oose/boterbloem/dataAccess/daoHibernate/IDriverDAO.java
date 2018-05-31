package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.DriverEntity;

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
