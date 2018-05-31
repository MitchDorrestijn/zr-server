package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDrivercarDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;

public class DrivercarDAOImpl extends GenericDAOImpl<DrivercarEntity> implements IDrivercarDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DrivercarDAOImpl() {
        super(DrivercarEntity.class);
    }

    public DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK){
        DrivercarEntity  drivercarEntity = getEntityManager().find(DrivercarEntity.class, drivercarEntityPK);
        return drivercarEntity;
    }


    @SuppressWarnings("unchecked")
    public DrivercarEntity findCarById(int id) {
        try {
            String utility;
            try {
                utility = (String) this.getEntityManager().createQuery("SELECT utility FROM DrivercarEntity dr WHERE dr.driverId = :driverId").setParameter("driverId", id).getSingleResult();
            } catch (NoResultException e){
                return new DrivercarEntity();
            }
            DrivercarEntityPK drivercarEntityPK = new DrivercarEntityPK();
            drivercarEntityPK.setDriverId(id);
            drivercarEntityPK.setUtility(utility);
            DrivercarEntity drivercarEntity = findByPK(drivercarEntityPK);
            return  drivercarEntity;

        } catch(NullPointerException e){
            return new DrivercarEntity();
        }
    }
}