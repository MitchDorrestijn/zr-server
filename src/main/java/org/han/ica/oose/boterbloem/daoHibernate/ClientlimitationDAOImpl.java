package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.ClientLimitationEntity;
import org.han.ica.oose.boterbloem.entity.DriverlimitationmanageableEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ClientlimitationDAOImpl extends GenericDAOImpl <ClientLimitationEntity> implements IClientlimitationDAO {

    /**
     * Hook up the basic CRUD queries
     *
     * @param em [provided] - runs querys
     */
    @Autowired
    public ClientlimitationDAOImpl(EntityManager em) {
        super(em, ClientLimitationEntity.class);
    }

    @Override
    public ArrayList <String> getByClientId(int id) {
        return (ArrayList <String>) getEntityManager().createQuery("SELECT limitation FROM ClientLimitationEntity " +
                "WHERE clientId = :id").setParameter("id", id).getResultList();
    }

    /**
     * @param id of Client
     * @return List of ClientLimitation
     */

//    @SuppressWarnings("unchecked")
//    public List <String> getAllLimitationById(int id) {
//        return getEntityManager().createQuery("SELECT limitation FROM ClientLimitationEntity " +
//                "WHERE clientId = :id").setParameter("id", id).getResultList();
//    }

    @Override
    public void updateClientLimitations(ArrayList <String> limitations, int clientId) {
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
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
    }

}
