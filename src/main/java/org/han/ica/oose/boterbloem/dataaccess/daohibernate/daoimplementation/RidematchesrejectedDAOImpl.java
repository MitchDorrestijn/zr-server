package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;


import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRidematchesrejectedDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RidematchesrejectedEntity;

public class RidematchesrejectedDAOImpl extends GenericDAOImpl<RidematchesrejectedEntity> implements IRidematchesrejectedDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    public RidematchesrejectedDAOImpl() {
        super(RidematchesrejectedEntity.class);
    }
}
