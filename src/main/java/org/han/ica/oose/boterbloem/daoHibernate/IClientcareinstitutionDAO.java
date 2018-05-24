package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.ClientcareinstitutionEntity;
import org.han.ica.oose.boterbloem.entity.ClientcareinstitutionEntityPK;

public interface IClientcareinstitutionDAO extends IGenericDAO<ClientcareinstitutionEntity> {
    ClientcareinstitutionEntity find(ClientcareinstitutionEntityPK drivercareinstitutionEntityPK);

    int getClientCareinstitutionId(int id);

    ClientcareinstitutionEntity findById(ClientcareinstitutionEntity clientcareinstitutionEntity);

    ClientcareinstitutionEntity getCareInstitutionId(int driverId);
}
