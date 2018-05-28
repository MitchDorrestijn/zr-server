package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.RidecanceledbydriverEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RidecanceledbydriverDAOImpl extends GenericDAOImpl<RidecanceledbydriverEntity> implements IRidecanceledbydriverDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public RidecanceledbydriverDAOImpl() {
        super(RidecanceledbydriverEntity.class);
    }
}
