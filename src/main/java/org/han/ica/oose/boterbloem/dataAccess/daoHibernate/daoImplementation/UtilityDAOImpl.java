package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IUtilityDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.UtilityEntity;
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
