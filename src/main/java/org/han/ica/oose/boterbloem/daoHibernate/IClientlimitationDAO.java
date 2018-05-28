package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.ClientLimitationEntity;

import java.util.List;

public interface IClientlimitationDAO extends IGenericDAO <ClientLimitationEntity> {

    List getByClientId(int id);

    List<String> getAllLimitationById(int id);

    void updateClientLimitations(List<String> limitations, int clientId);
}
