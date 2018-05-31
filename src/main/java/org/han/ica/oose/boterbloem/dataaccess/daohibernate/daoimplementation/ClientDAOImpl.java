package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public List<ClientEntity> getByCareInstitutionId(int id) {
        List<ClientEntity> clientEntities = new ArrayList<>();
        try {
            List<ClientcareinstitutionEntity> clientcareinstitutionEntityList = getEntityManager().createQuery("FROM ClientcareinstitutionEntity " +
                    "WHERE careInstitutionId = :id").setParameter("id", id).getResultList();

            for (int i = 0; i < clientcareinstitutionEntityList.size(); i++) {
                clientEntities.add(findById(clientcareinstitutionEntityList.get(i).getClientId()));
            }
        } catch (NullPointerException e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return clientEntities;
    }
}