package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.ClientcareinstitutionEntity;
import org.han.ica.oose.boterbloem.entity.ClientcareinstitutionEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class ClientcareinstitutionDAOImpl extends GenericDAOImpl<ClientcareinstitutionEntity> implements IClientcareinstitutionDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public ClientcareinstitutionDAOImpl() {
        super(ClientcareinstitutionEntity.class);
    }

    @SuppressWarnings("unchecked")
    public ClientcareinstitutionEntity getCareInstitutionId(int clientId){
        try {
            int careId;
            try {
                careId = (int) this.getEntityManager().createQuery("SELECT careInstitutionId FROM ClientcareinstitutionEntity c WHERE c.clientId = :clientid").setParameter("clientid", clientId).getSingleResult();
            }catch (NoResultException e){
                return new ClientcareinstitutionEntity();
            }
            ClientcareinstitutionEntityPK clientcareinstitutionEntityPK = new ClientcareinstitutionEntityPK();
            clientcareinstitutionEntityPK.setClientId(clientId);
            clientcareinstitutionEntityPK.setCareInstitutionId(careId);
            return  find(clientcareinstitutionEntityPK);
        } catch(NullPointerException e){
            System.out.println("check");
            return new ClientcareinstitutionEntity();
        }
    }

    @Override
    public int getClientCareinstitutionId(int id) {
        return ((int) getEntityManager().createQuery("select careInstitutionId from ClientcareinstitutionEntity where clientId   = :id").setParameter("id", id).getSingleResult());
    }

    public ClientcareinstitutionEntity find(ClientcareinstitutionEntityPK clientcareinstitutionEntityPK){
        return getEntityManager().find(ClientcareinstitutionEntity.class, clientcareinstitutionEntityPK);
    }

    public ClientcareinstitutionEntity findById(ClientcareinstitutionEntity clientcareinstitutionEntity){
        return getEntityManager().find(ClientcareinstitutionEntity.class, clientcareinstitutionEntity);
    }
}
