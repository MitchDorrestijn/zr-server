package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriverlimitationmanageableDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverlimitationmanageableEntity;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DriverlimitationmanageableDAOImpl extends GenericDAOImpl<DriverlimitationmanageableEntity> implements IDriverlimitationmanageableDAO {
    private static final Logger LOGGER = Logger.getLogger(DrivercareinstitutionDAOImpl.class.getName());

    /**
     * Hook up the basic CRUD queries
     */

    public DriverlimitationmanageableDAOImpl() {
        super(DriverlimitationmanageableEntity.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getByDriverId(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT limitation FROM DriverlimitationmanageableEntity WHERE driverId = :id").setParameter("id", id).getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateDriverLimitations(List<String> limitations, int driverId) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            em.createQuery("DELETE FROM DriverlimitationmanageableEntity WHERE driverId  = :driverId").setParameter("driverId", driverId).executeUpdate();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        for (String limitation : limitations) {
            try {
                DriverlimitationmanageableEntity driverlimitationmanageableEntity = new DriverlimitationmanageableEntity();
                driverlimitationmanageableEntity.setDriverId(driverId);
                driverlimitationmanageableEntity.setLimitation(limitation);
                add(driverlimitationmanageableEntity);
                em.flush();
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            } finally {
                em.close();
            }
        }
    }
}