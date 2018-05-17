package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.ClientcareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientCareInstitutionDAOImpl extends GenericDAOImpl<ClientcareinstitutionEntity> implements IClientCareInstitutionDAOm {

    @Autowired
    public ClientCareInstitutionDAOImpl(EntityManager em) {
        super(em, ClientcareinstitutionEntity.class);
    }
}
