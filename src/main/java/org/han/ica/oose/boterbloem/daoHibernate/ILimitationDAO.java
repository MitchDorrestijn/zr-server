package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.LimitationEntity;

public interface ILimitationDAO extends IGenericDAO<LimitationEntity> {
    LimitationEntity findByName(String name);
}
