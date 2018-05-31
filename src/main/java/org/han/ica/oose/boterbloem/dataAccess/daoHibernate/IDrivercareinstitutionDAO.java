package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.DrivercareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataAccess.entities.DrivercareinstitutionEntityPK;

public interface IDrivercareinstitutionDAO extends IGenericDAO<DrivercareinstitutionEntity> {

    DrivercareinstitutionEntity find(DrivercareinstitutionEntityPK drivercareinstitutionEntityPK);

    int getDriverCareinstitutionId(int id);

    DrivercareinstitutionEntity findById(DrivercareinstitutionEntity drivercareinstitutionEntity);

    DrivercareinstitutionEntity getCareInstitutionId(int driverId);

    void updateCareInstituion(int careId, int driverId);
}
