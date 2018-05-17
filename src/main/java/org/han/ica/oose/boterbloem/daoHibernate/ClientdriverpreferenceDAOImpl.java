package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.ClientdriverpreferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientdriverpreferenceDAOImpl extends GenericDAOImpl<ClientdriverpreferenceEntity> implements IClientdriverpreferenceDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public ClientdriverpreferenceDAOImpl(EntityManager em) {
        super(em, ClientdriverpreferenceEntity.class);
    }
}
