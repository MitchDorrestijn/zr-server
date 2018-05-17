package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.ClientlimitationEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientLimitationDAOImpl extends GenericDAOImpl<ClientlimitationEntity> implements IClientLimitationDAOm {

    @Autowired
    public ClientLimitationDAOImpl(EntityManager em) {
        super(em, ClientlimitationEntity.class);
    }
}
