package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IRidematchescacheDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.RidematchescacheEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class RidematchescacheDAOImpl extends GenericDAOImpl<RidematchescacheEntity> implements IRidematchescacheDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public RidematchescacheDAOImpl() {
        super(RidematchescacheEntity.class);
    }
}
