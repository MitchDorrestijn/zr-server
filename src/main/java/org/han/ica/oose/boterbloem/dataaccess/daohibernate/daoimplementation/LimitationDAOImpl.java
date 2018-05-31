package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ILimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.LimitationEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class LimitationDAOImpl extends GenericDAOImpl<LimitationEntity> implements ILimitationDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public LimitationDAOImpl() {
        super(LimitationEntity.class);
    }

    @Override
    public LimitationEntity findByName(String name) {
        return (LimitationEntity) getEntityManager().createQuery("FROM LimitationEntity "+
                "WHERE name = :name").setParameter("name", name).getSingleResult();
    }
}