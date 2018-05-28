package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
       // getEntityManager().getTransaction().begin();
        DrivercarEntity  drivercarEntity = getEntityManager().find(DrivercarEntity.class, drivercarEntityPK);
       // getEntityManager().getTransaction().commit();
        return drivercarEntity;
    }


    @SuppressWarnings("unchecked")
    public DrivercarEntity findCarById(int id) {
        try {
            String utility;
            try {
             //   getEntityManager().getTransaction().begin();
                utility = (String) this.getEntityManager().createQuery("SELECT utility FROM DrivercarEntity dr WHERE dr.driverId = :driverId").setParameter("driverId", id).getSingleResult();
              //  getEntityManager().getTransaction().commit();
            } catch (NoResultException e){
                return new DrivercarEntity();
            }
           // getEntityManager().getTransaction().begin();
            DrivercarEntityPK drivercarEntityPK = new DrivercarEntityPK();
            drivercarEntityPK.setDriverId(id);
            drivercarEntityPK.setUtility(utility);
            System.out.println(utility);
            DrivercarEntity drivercarEntity = findByPK(drivercarEntityPK);
            //getEntityManager().getTransaction().commit();
            return  drivercarEntity;

        } catch(NullPointerException e){
            System.out.println("check");
            return new DrivercarEntity();

        }
    }
}
