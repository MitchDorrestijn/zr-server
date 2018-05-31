package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IClientUtilityDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.ClientUtilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientUtilityDAO extends GenericDAOImpl<ClientUtilityEntity> implements IClientUtilityDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientUtilityDAO() {
        super(ClientUtilityEntity.class);
    }
}
