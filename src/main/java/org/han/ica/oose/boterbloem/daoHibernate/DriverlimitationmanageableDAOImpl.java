package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.DriverlimitationmanageableEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class DriverlimitationmanageableDAOImpl extends GenericDAOImpl<DriverlimitationmanageableEntity> implements IDriverlimitationmanageableDAO {

    /**
     * Hook up the basic CRUD queries
     *
     * @param em [provided] - runs querys
     */
    @Autowired
    public DriverlimitationmanageableDAOImpl(EntityManager em) {
        super(em, DriverlimitationmanageableEntity.class);
    }

    @Override
    public ArrayList<String> getByDriverId(int id) {
        return (ArrayList<String>) getEntityManager().createQuery("SELECT limitation FROM DriverlimitationmanageableEntity WHERE driverId = :id").setParameter("id", id).getResultList();
    }

    public void updateDriverLimitations(ArrayList<String> limitations, int driverId) {
        getEntityManager().getTransaction().begin();
        getEntityManager().createQuery("DELETE FROM DriverlimitationmanageableEntity WHERE driverId  = :driverId").setParameter("driverId", driverId).executeUpdate();
        getEntityManager().getTransaction().commit();
        for (String limitation : limitations) {
            try {
                DriverlimitationmanageableEntity driverlimitationmanageableEntity = new DriverlimitationmanageableEntity();
                driverlimitationmanageableEntity.setDriverId(driverId);
                driverlimitationmanageableEntity.setLimitation(limitation);
                add(driverlimitationmanageableEntity);
                getEntityManager().flush();
            }catch(Exception e){
                
            }
        }
    }

}