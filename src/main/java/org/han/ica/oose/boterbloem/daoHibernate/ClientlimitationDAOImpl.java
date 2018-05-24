package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.ClientlimitationEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientlimitationDAOImpl extends GenericDAOImpl <ClientlimitationEntity> implements IClientlimitationDAO {

    /**
     * Hook up the basic CRUD queries
     *
     * @param em [provided] - runs querys
     */
    @Autowired
    public ClientlimitationDAOImpl(EntityManager em) {
        super(em, ClientlimitationEntity.class);
    }

    /**
     * @param id of Client
     * @return List of ClientLimitation
     */
    public List<String> getAllLimitationById(int id) {
        return getEntityManager().createQuery("SELECT limitation FROM ClientlimitationEntity " +
                "WHERE clientId = :id").setParameter("id", id).getResultList();

    }
}
