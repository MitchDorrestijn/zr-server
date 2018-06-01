package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class RidematchescacheDAOImpl extends GenericDAOImpl<RidematchescacheEntity> implements IRidematchescacheDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public RidematchescacheDAOImpl() {
        super(RidematchescacheEntity.class);
    }
}
