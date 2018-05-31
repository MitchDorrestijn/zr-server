package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.LimitationEntity;

public interface ILimitationDAO extends IGenericDAO<LimitationEntity> {
    /**
     * Find limitation by a given name
     * @param name
     * @return
     */
    LimitationEntity findByName(String name);
}
