package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.ClientlimitationEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientlimitationDAOImpl extends GenericDAOImpl<ClientlimitationEntity> implements IClientlimitationDAO {

    @Autowired
    public ClientlimitationDAOImpl(EntityManager em) {
        super(em, ClientlimitationEntity.class);
    }
}
