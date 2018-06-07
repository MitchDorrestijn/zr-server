package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientlimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientLimitationEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientlimitationDAOImpl extends GenericDAOImpl<ClientLimitationEntity> implements IClientlimitationDAO {
    private static final Logger LOGGER = Logger.getLogger(ClientlimitationDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientlimitationDAOImpl() {
        super(ClientLimitationEntity.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getByClientId(int id) {
        try {
            return getEntityManager().createQuery("SELECT limitation FROM ClientLimitationEntity " +
                    "WHERE clientId = :id").setParameter("id", id).getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return new ArrayList<>();

    }

    /**
     * @param id of Client
     * @return List of ClientLimitation
     */

    @SuppressWarnings("unchecked")
    public List<String> getAllLimitationById(int id) {
        try {
            return getEntityManager().createQuery("SELECT limitation FROM ClientLimitationEntity " +
                    "WHERE clientId = :id").setParameter("id", id).getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void updateClientLimitations(List<String> limitations, int clientId) {
        getEntityManager().createQuery("DELETE FROM ClientLimitationEntity WHERE clientId  = :clientId").setParameter("clientId", clientId).executeUpdate();
        getEntityManager().flush();
        for (String limitation : limitations) {
            try {
                ClientLimitationEntity clientLimitationEntity = new ClientLimitationEntity();
                clientLimitationEntity.setClientId(clientId);
                clientLimitationEntity.setLimitation(limitation);
                add(clientLimitationEntity);
                getEntityManager().flush();
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }
        }
    }

}
