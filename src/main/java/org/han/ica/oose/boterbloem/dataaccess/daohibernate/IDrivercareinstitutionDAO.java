package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public interface IDrivercareinstitutionDAO extends IGenericDAO<DrivercareinstitutionEntity> {

    DrivercareinstitutionEntity find(DrivercareinstitutionEntityPK drivercareinstitutionEntityPK);

    int getDriverCareinstitutionId(int id);

    DrivercareinstitutionEntity findById(DrivercareinstitutionEntity drivercareinstitutionEntity);

    DrivercareinstitutionEntity getCareInstitutionId(int driverId);

    void updateCareInstituion(int careId, int driverId);
}
