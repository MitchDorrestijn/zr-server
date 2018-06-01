package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class LimitationDAOImpl extends GenericDAOImpl<LimitationEntity> implements ILimitationDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public LimitationDAOImpl() {
        super(LimitationEntity.class);
    }

    @Override
    public LimitationEntity findByName(String name) {
        return (LimitationEntity) getEntityManager().createQuery("FROM LimitationEntity "+
                "WHERE name = :name").setParameter("name", name).getSingleResult();
    }
}
