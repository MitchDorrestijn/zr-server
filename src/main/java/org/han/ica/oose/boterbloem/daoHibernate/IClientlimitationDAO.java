package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.ClientLimitationEntity;

import java.util.ArrayList;
import java.util.List;

public interface IClientlimitationDAO extends IGenericDAO <ClientLimitationEntity> {

    ArrayList<String> getByClientId(int id);

//    List<String> getAllLimitationById(int id);

    void updateClientLimitations(ArrayList<String> limitations, int clientId);
}
