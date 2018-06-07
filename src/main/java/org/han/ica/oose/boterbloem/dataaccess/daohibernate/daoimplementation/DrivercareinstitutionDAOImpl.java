package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDrivercareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntityPK;

import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DrivercareinstitutionDAOImpl extends GenericDAOImpl<DrivercareinstitutionEntity> implements IDrivercareinstitutionDAO {
    private static final Logger LOGGER = Logger.getLogger(DrivercareinstitutionDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */
    public DrivercareinstitutionDAOImpl() {
        super(DrivercareinstitutionEntity.class);
    }

    public DrivercareinstitutionEntity find(DrivercareinstitutionEntityPK drivercareinstitutionEntityPK) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            return em.find(DrivercareinstitutionEntity.class, drivercareinstitutionEntityPK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new DrivercareinstitutionEntity();
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
    public DrivercareinstitutionEntity getCareInstitutionId(int driverId) {
        try {
            int careId = getCareId(driverId);
            DrivercareinstitutionEntityPK drivercareinstitutionEntityPK = new DrivercareinstitutionEntityPK();
            drivercareinstitutionEntityPK.setDriverId(driverId);
            drivercareinstitutionEntityPK.setCareInstitutionId(careId);
            return find(drivercareinstitutionEntityPK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new DrivercareinstitutionEntity();
        }
    }

    private int getCareId(int driverId) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            return (int) em.createQuery("SELECT careInstitutionId FROM DrivercareinstitutionEntity dr WHERE dr.driverId = :driverId").setParameter("driverId", driverId).getSingleResult();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return 0;
        } finally {
            em.close();
        }
    }

    @Override
    public void updateCareInstituion(int careId, int driverId) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("UPDATE DrivercareinstitutionEntity SET careInstitutionId = :careId WHERE driverId = :driverId").setParameter("careId", careId).setParameter("driverId", driverId).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public int getDriverCareinstitutionId(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            return ((int) em.createQuery("select careInstitutionId from DrivercareinstitutionEntity where driverId = :id").setParameter("id", id).getSingleResult());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return 0;
        } finally {
            em.close();
        }

    }

    public DrivercareinstitutionEntity findById(DrivercareinstitutionEntity drivercareinstitutionEntity) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            return em.find(DrivercareinstitutionEntity.class, drivercareinstitutionEntity);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } finally {
            em.close();
        }
        return null;
    }

}
