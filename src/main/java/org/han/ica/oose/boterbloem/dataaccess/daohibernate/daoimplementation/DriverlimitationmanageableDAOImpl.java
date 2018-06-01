package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

import java.util.*;
import java.util.logging.*;

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
        return getEntityManager().createQuery("SELECT limitation FROM DriverlimitationmanageableEntity WHERE driverId = :id").setParameter("id", id).getResultList();
    }

    @Override
    public void updateDriverLimitations(List<String> limitations, int driverId) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().createQuery("DELETE FROM DriverlimitationmanageableEntity WHERE driverId  = :driverId").setParameter("driverId", driverId).executeUpdate();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }
        for (String limitation : limitations) {
            try {
                DriverlimitationmanageableEntity driverlimitationmanageableEntity = new DriverlimitationmanageableEntity();
                driverlimitationmanageableEntity.setDriverId(driverId);
                driverlimitationmanageableEntity.setLimitation(limitation);
                add(driverlimitationmanageableEntity);
                getEntityManager().flush();
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }
        }
    }
}