package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntityPK;

public interface IClientcareinstitutionDAO extends IGenericDAO<ClientcareinstitutionEntity> {
    ClientcareinstitutionEntity find(ClientcareinstitutionEntityPK drivercareinstitutionEntityPK);

    int getClientCareinstitutionId(int id);

    ClientcareinstitutionEntity findById(ClientcareinstitutionEntity clientcareinstitutionEntity);

    ClientcareinstitutionEntity getCareInstitutionId(int driverId);
}
