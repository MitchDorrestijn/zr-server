package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.ClientcareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientcareinstitutionDAOImpl extends GenericDAOImpl<ClientcareinstitutionEntity> implements IClientcareinstitutionDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public ClientcareinstitutionDAOImpl(EntityManager em) {
        super(em, ClientcareinstitutionEntity.class);
    }
}
