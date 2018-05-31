package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientUtilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientUtilityEntity;

public class ClientUtilityDAO extends GenericDAOImpl<ClientUtilityEntity> implements IClientUtilityDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public ClientUtilityDAO() {
        super(ClientUtilityEntity.class);
    }
}
