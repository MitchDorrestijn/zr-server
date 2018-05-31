package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRidecanceledbydriverDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RidecanceledbydriverEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class RidecanceledbydriverDAOImpl extends GenericDAOImpl<RidecanceledbydriverEntity> implements IRidecanceledbydriverDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public RidecanceledbydriverDAOImpl() {
        super(RidecanceledbydriverEntity.class);
    }
}
