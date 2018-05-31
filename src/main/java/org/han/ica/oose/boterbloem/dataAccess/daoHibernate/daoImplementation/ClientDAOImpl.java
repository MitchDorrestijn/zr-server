package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientDAOImpl extends GenericDAOImpl<ClientEntity> implements IClientDAO {
    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientDAOImpl() {
        super(ClientEntity.class);
    }
    @Override
    public void removeById(int clientId) {
        getEntityManager().createQuery("UPDATE ClientcareinstitutionEntity SET ClientcareinstitutionEntity .active = false " +
                "WHERE ClientcareinstitutionEntity.clientId= :clientId").setParameter("clientId", clientId).executeUpdate();
    }
}
