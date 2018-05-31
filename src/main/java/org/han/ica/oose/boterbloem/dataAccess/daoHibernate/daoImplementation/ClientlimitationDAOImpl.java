package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IClientlimitationDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.ClientLimitationEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientlimitationDAOImpl extends GenericDAOImpl<ClientLimitationEntity> implements IClientlimitationDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientlimitationDAOImpl() {
        super(ClientLimitationEntity.class);
    }

    @Override
    public List<String> getByClientId(int id) {
        return getEntityManager().createQuery("SELECT limitation FROM ClientLimitationEntity " +
                "WHERE clientId = :id").setParameter("id", id).getResultList();
    }

    /**
     * @param id of Client
     * @return List of ClientLimitation
     */

    @SuppressWarnings("unchecked")
    public List<String> getAllLimitationById(int id) {
        return getEntityManager().createQuery("SELECT limitation FROM ClientLimitationEntity " +
                "WHERE clientId = :id").setParameter("id", id).getResultList();
    }

    @Override
    public void updateClientLimitations(List<String> limitations, int clientId) {
        getEntityManager().getTransaction().begin();
        getEntityManager().createQuery("DELETE FROM ClientLimitationEntity WHERE clientId  = :clientId").setParameter("clientId", clientId).executeUpdate();
        getEntityManager().getTransaction().commit();
        for (String limitation : limitations) {
            try {
                ClientLimitationEntity clientLimitationEntity = new ClientLimitationEntity();
                clientLimitationEntity.setClientId(clientId);
                clientLimitationEntity.setLimitation(limitation);
                add(clientLimitationEntity);
                getEntityManager().flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
