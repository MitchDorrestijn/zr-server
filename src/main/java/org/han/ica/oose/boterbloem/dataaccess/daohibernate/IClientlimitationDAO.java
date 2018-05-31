package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientLimitationEntity;

import java.util.List;

public interface IClientlimitationDAO extends IGenericDAO <ClientLimitationEntity> {

    List<String> getByClientId(int id);

    List<String> getAllLimitationById(int id);

    void updateClientLimitations(List<String> limitations, int clientId);
}
