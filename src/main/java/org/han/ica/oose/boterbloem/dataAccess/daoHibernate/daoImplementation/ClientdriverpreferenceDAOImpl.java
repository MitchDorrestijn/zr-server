package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IClientdriverpreferenceDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.ClientdriverpreferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientdriverpreferenceDAOImpl extends GenericDAOImpl<ClientdriverpreferenceEntity> implements IClientdriverpreferenceDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientdriverpreferenceDAOImpl() {
        super(ClientdriverpreferenceEntity.class);
    }
}
