package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.entity.ClientcareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ClientEntity> getByCareInstitutionId(int id) {
        List<ClientcareinstitutionEntity> clientcareinstitutionEntityList = getEntityManager().createQuery("FROM ClientcareinstitutionEntity " +
                "WHERE careInstitutionId = :id").setParameter("id", id).getResultList();

        List<ClientEntity> clientEntities = new ArrayList<>();
        for(int i = 0; i < clientcareinstitutionEntityList.size(); i++) {
            clientEntities.add(findById(clientcareinstitutionEntityList.get(i).getClientId()));
        }
        return clientEntities;
    }

}
