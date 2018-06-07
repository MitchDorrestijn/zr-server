package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientcareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientcareinstitutionDAOImpl extends GenericDAOImpl<ClientcareinstitutionEntity> implements IClientcareinstitutionDAO {
    private static final Logger LOGGER = Logger.getLogger(ClientcareinstitutionDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientcareinstitutionDAOImpl() {
        super(ClientcareinstitutionEntity.class);
    }

    /**
     * returns careinstituion based on clientId
     *
     * @param clientId id fo a client
     * @return Clientcareinstitution entity
     */
    @SuppressWarnings("unchecked")
    public ClientcareinstitutionEntity getCareInstitutionId(int clientId) {
        try {
            ClientcareinstitutionEntityPK clientcareinstitutionEntityPK = new ClientcareinstitutionEntityPK();
            clientcareinstitutionEntityPK.setClientId(clientId);
            clientcareinstitutionEntityPK.setCareInstitutionId(getClientCareinstitutionId(clientId));
            return find(clientcareinstitutionEntityPK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new ClientcareinstitutionEntity();
        }
    }

    /**
     * returns the id of the carinstitution in which the client resides
     *
     * @param id of the client
     * @return id of careinstitution
     */
    @Override
    public int getClientCareinstitutionId(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            return ((int) em.createQuery("select careInstitutionId from ClientcareinstitutionEntity where clientId   = :id").setParameter("id", id).getSingleResult());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } finally {
            em.close();
        }
        return 0;
    }

    public ClientcareinstitutionEntity find(ClientcareinstitutionEntityPK clientcareinstitutionEntityPK) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        ClientcareinstitutionEntity clientcareinstitutionEntity = em.find(ClientcareinstitutionEntity.class, clientcareinstitutionEntityPK);
        em.close();
        return clientcareinstitutionEntity;
    }

    public ClientcareinstitutionEntity findById(ClientcareinstitutionEntity clientcareinstitutionEntity) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        ClientcareinstitutionEntity clientcareinstitutionEntityA = em.find(ClientcareinstitutionEntity.class, clientcareinstitutionEntity);
        em.close();
        return clientcareinstitutionEntityA;
    }
}
