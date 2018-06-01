package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

import javax.persistence.*;

public class DrivercarDAOImpl extends GenericDAOImpl<DrivercarEntity> implements IDrivercarDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public DrivercarDAOImpl() {
        super(DrivercarEntity.class);
    }

    public DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK) {
        try {
            return getEntityManager().find(DrivercarEntity.class, drivercarEntityPK);
        } catch (Exception e) {
            return new DrivercarEntity();
        }
    }


    @SuppressWarnings("unchecked")
    public DrivercarEntity findCarById(int id) {
        try {
            String utility;
            try {
                utility = (String) this.getEntityManager().createQuery("SELECT utility FROM DrivercarEntity dr WHERE dr.driverId = :driverId").setParameter("driverId", id).getSingleResult();
            } catch (NoResultException e) {
                return new DrivercarEntity();
            }
            DrivercarEntityPK drivercarEntityPK = new DrivercarEntityPK();
            drivercarEntityPK.setDriverId(id);
            drivercarEntityPK.setUtility(utility);
            return findByPK(drivercarEntityPK);

        } catch (NullPointerException e) {
            return new DrivercarEntity();
        }
    }
}
