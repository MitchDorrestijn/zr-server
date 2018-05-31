package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUtilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class UtilityDAOImpl extends GenericDAOImpl<UtilityEntity> implements IUtilityDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public UtilityDAOImpl() {
        super(UtilityEntity.class);
    }
}
