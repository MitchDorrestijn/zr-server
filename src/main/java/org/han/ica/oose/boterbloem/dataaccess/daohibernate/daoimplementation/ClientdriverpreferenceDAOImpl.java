package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientdriverpreferenceDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientdriverpreferenceEntity;
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
