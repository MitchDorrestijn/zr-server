package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientcareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientcareinstitutionEntityPK;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientcareinstitutionDAOImpl extends GenericDAOImpl<ClientcareinstitutionEntity> implements IClientcareinstitutionDAO {
    private static final Logger LOGGER = Logger.getLogger(ClientcareinstitutionDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */
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
        } catch (NullPointerException e) {
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
        try {
            return ((int) getEntityManager().createQuery("select careInstitutionId from ClientcareinstitutionEntity where clientId   = :id").setParameter("id", id).getSingleResult());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());

        }
        return 0;
    }

    /**
     * finds careinstitution by compositekey
     *
     * @param clientcareinstitutionEntityPK compositeKey
     * @return careinstitution entity
     */
    public ClientcareinstitutionEntity find(ClientcareinstitutionEntityPK clientcareinstitutionEntityPK) {
        return getEntityManager().find(ClientcareinstitutionEntity.class, clientcareinstitutionEntityPK);
    }

    public ClientcareinstitutionEntity findById(ClientcareinstitutionEntity clientcareinstitutionEntity) {
        return getEntityManager().find(ClientcareinstitutionEntity.class, clientcareinstitutionEntity);
    }
}
