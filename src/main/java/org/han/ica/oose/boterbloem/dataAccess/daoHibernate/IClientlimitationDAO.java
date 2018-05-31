package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.ClientLimitationEntity;

import java.util.List;

public interface IClientlimitationDAO extends IGenericDAO <ClientLimitationEntity> {

    List<String> getByClientId(int id);

    List<String> getAllLimitationById(int id);

    void updateClientLimitations(List<String> limitations, int clientId);
}
