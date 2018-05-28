package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.ClientdriverpreferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientdriverpreferenceDAOImpl extends GenericDAOImpl<ClientdriverpreferenceEntity> implements IClientdriverpreferenceDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientdriverpreferenceDAOImpl() {
        super(ClientdriverpreferenceEntity.class);
    }
}
