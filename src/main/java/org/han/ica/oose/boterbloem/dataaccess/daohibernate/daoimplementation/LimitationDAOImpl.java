package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ILimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.LimitationEntity;

import javax.persistence.EntityManager;
import java.util.logging.Level;

public class LimitationDAOImpl extends GenericDAOImpl<LimitationEntity> implements ILimitationDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public LimitationDAOImpl() {
        super(LimitationEntity.class);
    }

    @Override
    public LimitationEntity findByName(String name) {
        try {
            return (LimitationEntity) getEntityManager().createQuery("FROM LimitationEntity " +
                    "WHERE name = :name").setParameter("name", name).getSingleResult();
        }catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
            return new LimitationEntity();
        }
    }
}
