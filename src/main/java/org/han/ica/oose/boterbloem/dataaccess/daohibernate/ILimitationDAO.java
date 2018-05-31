package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.LimitationEntity;

public interface ILimitationDAO extends IGenericDAO<LimitationEntity> {
    /**
     * Find limitation by a given name
     * @param name
     * @return
     */
    LimitationEntity findByName(String name);
}
