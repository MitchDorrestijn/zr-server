package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class RidecanceledbydriverDAOImpl extends GenericDAOImpl<RidecanceledbydriverEntity> implements IRidecanceledbydriverDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public RidecanceledbydriverDAOImpl() {
        super(RidecanceledbydriverEntity.class);
    }
}
