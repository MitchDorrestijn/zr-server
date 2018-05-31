package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IDriverlimitationmanageableDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.DriverlimitationmanageableEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DriverlimitationmanageableDAOImpl extends GenericDAOImpl<DriverlimitationmanageableEntity> implements IDriverlimitationmanageableDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DriverlimitationmanageableDAOImpl() {
        super(DriverlimitationmanageableEntity.class);
    }

    @Override
    public List<String> getByDriverId(int id) {
        return getEntityManager().createQuery("SELECT limitation FROM DriverlimitationmanageableEntity WHERE driverId = :id").setParameter("id", id).getResultList();
    }

    public void updateDriverLimitations(ArrayList<String> limitations, int driverId) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().createQuery("DELETE FROM DriverlimitationmanageableEntity WHERE driverId  = :driverId").setParameter("driverId", driverId).executeUpdate();
            getEntityManager().getTransaction().commit();
        } catch(Exception e){
            getEntityManager().getTransaction().rollback();
        }
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