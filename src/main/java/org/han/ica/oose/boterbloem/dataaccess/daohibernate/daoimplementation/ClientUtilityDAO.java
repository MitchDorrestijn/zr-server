package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class ClientUtilityDAO extends GenericDAOImpl<ClientUtilityEntity> implements IClientUtilityDAO {

    /**
     * Hook up the basic CRUD queries
     */
    public ClientUtilityDAO() {
        super(ClientUtilityEntity.class);
    }
}
