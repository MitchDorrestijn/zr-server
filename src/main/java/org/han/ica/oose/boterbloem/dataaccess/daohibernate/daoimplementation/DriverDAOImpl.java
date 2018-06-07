package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DriverDAOImpl extends GenericDAOImpl<DriverEntity> implements IDriverDAO {

    private static final Logger LOGGER = Logger.getLogger(DriverDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DriverDAOImpl() {
        super(DriverEntity.class);
    }

    public int latestId() {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            return ((Number) em.createQuery("SELECT MAX(driverId) FROM DriverEntity").getSingleResult()).intValue();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } finally {
            em.close();
        }
        return 0;
    }

    @Override
    public void deleteDriver(int driverId) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            em.createQuery("UPDATE DrivercareinstitutionEntity SET DrivercareinstitutionEntity.active = false " +
                    "WHERE DrivercareinstitutionEntity.driverId = :driverId").setParameter("driverId", driverId).getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<DriverEntity> getByCareInstitutionId(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        List<DriverEntity> driverEntities = new ArrayList<>();
        try {
            List<DrivercareinstitutionEntity> drivercareinstitutionEntities = em.createQuery("FROM DrivercareinstitutionEntity " +
                    "WHERE careInstitutionId = :id").setParameter("id", id).getResultList();

            for (DrivercareinstitutionEntity dr : drivercareinstitutionEntities) {
                driverEntities.add(findById(dr.getDriverId()));
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        } finally {
            em.close();
        }
        return driverEntities;
    }
}

