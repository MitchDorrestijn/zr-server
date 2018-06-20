package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUtilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;

import java.util.logging.Level;

public class UtilityDAOImpl extends GenericDAOImpl<UtilityEntity> implements IUtilityDAO {

    /**
     * Hook up the basic CRUD queries
     */
    public UtilityDAOImpl() {
        super(UtilityEntity.class);
    }

    @Override
    public UtilityEntity findByName(String name) {
        try {
            return (UtilityEntity) getEntityManager().createQuery("FROM UtilityEntity where name =:name").setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new UtilityEntity();
        }
    }
}
