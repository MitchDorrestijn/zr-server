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
        try {
            return ((Number) getEntityManager().createQuery("SELECT MAX(driverId) FROM DriverEntity").getSingleResult()).intValue();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return 0;
    }

    @Override
    public void deleteDriver(int driverId) {
        try {
            getEntityManager().createQuery("UPDATE DrivercareinstitutionEntity SET DrivercareinstitutionEntity.active = false " +
                    "WHERE DrivercareinstitutionEntity.driverId = :driverId").setParameter("driverId", driverId).getResultList();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<DriverEntity> getByCareInstitutionId(int id) {
        List<DriverEntity> driverEntities = new ArrayList<>();
        try {
            List<DrivercareinstitutionEntity> drivercareinstitutionEntities = getEntityManager().createQuery("FROM DrivercareinstitutionEntity " +
                    "WHERE careInstitutionId = :id").setParameter("id", id).getResultList();

            for (DrivercareinstitutionEntity dr : drivercareinstitutionEntities) {
                driverEntities.add(findById(dr.getDriverId()));
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return driverEntities;
    }
}

