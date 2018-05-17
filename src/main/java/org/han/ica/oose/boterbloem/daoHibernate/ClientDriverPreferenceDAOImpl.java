package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.ClientdriverpreferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientDriverPreferenceDAOImpl extends GenericDAOImpl<ClientdriverpreferenceEntity> implements IClientDriverPreferenceDAOm {

    @Autowired
    public ClientDriverPreferenceDAOImpl(EntityManager em) {
        super(em, ClientdriverpreferenceEntity.class);
    }
}
