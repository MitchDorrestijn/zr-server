package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class RidematchesstateDAOImpl extends GenericDAOImpl<RidematchesstateEntity> implements IRidematchesstateDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public RidematchesstateDAOImpl() {
        super(RidematchesstateEntity.class);
    }
}
