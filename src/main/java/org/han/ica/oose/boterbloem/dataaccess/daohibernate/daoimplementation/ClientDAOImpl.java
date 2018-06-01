package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.logging.*;

public class ClientDAOImpl extends GenericDAOImpl<ClientEntity> implements IClientDAO {
    private static final Logger LOGGER = Logger.getLogger(ClientDAOImpl.class.getName());

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

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<ClientEntity> getByCareInstitutionId(int id) {
        List<ClientEntity> clientEntities = new ArrayList<>();
        try {
            List<ClientcareinstitutionEntity> clientcareinstitutionEntityList = getEntityManager().createQuery("FROM ClientcareinstitutionEntity " +
                    "WHERE careInstitutionId = :id").setParameter("id", id).getResultList();

            for (ClientcareinstitutionEntity clientcareinstitutionEntity : clientcareinstitutionEntityList) {
                clientEntities.add(findById(clientcareinstitutionEntity.getClientId()));
            }
        } catch (NullPointerException e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return clientEntities;
    }
}
