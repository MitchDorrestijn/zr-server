package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.UtilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class UtilityDAOImpl extends GenericDAOImpl<UtilityEntity> implements IUtilityDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public UtilityDAOImpl() {
        super(UtilityEntity.class);
    }
}
