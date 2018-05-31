package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRidematchescacheDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RidematchescacheEntity;
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
