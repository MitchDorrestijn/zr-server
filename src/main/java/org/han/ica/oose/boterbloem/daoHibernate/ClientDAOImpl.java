package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientDAOImpl extends GenericDAOImpl<ClientEntity> implements IClientDAOm {

    @Autowired
    public ClientDAOImpl(EntityManager em) {
        super(em, ClientEntity.class);
    }
}
