package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;

public interface IUtilityDAO extends IGenericDAO<UtilityEntity> {
    UtilityEntity findByName(String name);
}
