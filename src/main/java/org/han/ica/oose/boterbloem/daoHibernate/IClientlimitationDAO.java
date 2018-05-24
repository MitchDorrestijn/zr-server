package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.ClientlimitationEntity;

import java.util.List;

public interface IClientlimitationDAO extends IGenericDAO <ClientlimitationEntity> {
    List<String> getAllLimitationById(int id);
}
