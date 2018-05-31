package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRidematchesstateDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RidematchesstateEntity;


public class RidematchesstateDAOImpl extends GenericDAOImpl<RidematchesstateEntity> implements IRidematchesstateDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public RidematchesstateDAOImpl() {
        super(RidematchesstateEntity.class);
    }
}
