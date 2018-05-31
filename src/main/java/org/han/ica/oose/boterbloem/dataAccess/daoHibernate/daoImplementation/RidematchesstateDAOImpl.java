package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IRidematchesstateDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.RidematchesstateEntity;
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
