package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.ClientcareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataAccess.entities.ClientcareinstitutionEntityPK;

public interface IClientcareinstitutionDAO extends IGenericDAO<ClientcareinstitutionEntity> {
    ClientcareinstitutionEntity find(ClientcareinstitutionEntityPK drivercareinstitutionEntityPK);

    int getClientCareinstitutionId(int id);

    ClientcareinstitutionEntity findById(ClientcareinstitutionEntity clientcareinstitutionEntity);

    ClientcareinstitutionEntity getCareInstitutionId(int driverId);
}
