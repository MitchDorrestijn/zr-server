package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IRidematchesrejectedDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.RidematchesrejectedEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class RidematchesrejectedDAOImpl extends GenericDAOImpl<RidematchesrejectedEntity> implements IRidematchesrejectedDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public RidematchesrejectedDAOImpl() {
        super(RidematchesrejectedEntity.class);
    }
}
