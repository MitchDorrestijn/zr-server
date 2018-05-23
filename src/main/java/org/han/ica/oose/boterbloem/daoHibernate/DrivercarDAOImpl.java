package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class DrivercarDAOImpl extends GenericDAOImpl<DrivercarEntity> implements IDrivercarDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public DrivercarDAOImpl(EntityManager em) {
        super(em, DrivercarEntity.class);
    }

    public DrivercarEntity findByPK(DrivercarEntityPK drivercarEntityPK){
        return getEntityManager().find(DrivercarEntity.class, drivercarEntityPK);
    }


    @SuppressWarnings("unchecked")
    public DrivercarEntity findCarById(int id) {
        try {
            String utility;
            try {
                utility = (String) this.getEntityManager().createQuery("SELECT utility FROM DrivercarEntity dr WHERE dr.driverId = :driverId").setParameter("driverId", id).getSingleResult();
            }catch (NoResultException e){
                return new DrivercarEntity();
            }
            DrivercarEntityPK drivercarEntityPK = new DrivercarEntityPK();
            drivercarEntityPK.setDriverId(id);
            drivercarEntityPK.setUtility(utility);
            System.out.println(utility);
            return  findByPK(drivercarEntityPK);

        } catch(NullPointerException e){
            System.out.println("check");
            return new DrivercarEntity();

        }
    }
}
