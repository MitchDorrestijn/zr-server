package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.ClientUtilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientUtilityDAO extends GenericDAOImpl<ClientUtilityEntity> implements IClientUtilityDAO{

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientUtilityDAO() {
        super(ClientUtilityEntity.class);
    }
}
