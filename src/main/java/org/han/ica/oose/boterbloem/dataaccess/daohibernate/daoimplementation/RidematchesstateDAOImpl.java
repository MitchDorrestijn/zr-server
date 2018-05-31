package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRidematchesstateDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RidematchesstateEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class RidematchesstateDAOImpl extends GenericDAOImpl<RidematchesstateEntity> implements IRidematchesstateDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public RidematchesstateDAOImpl() {
        super(RidematchesstateEntity.class);
    }
}
