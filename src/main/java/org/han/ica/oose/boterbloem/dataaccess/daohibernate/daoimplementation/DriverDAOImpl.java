package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

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


    public int latestId(){
        getEntityManager().getTransaction().begin();
        int returnvalue = ((Number) getEntityManager().createQuery("SELECT MAX(driverId) FROM DriverEntity").getSingleResult()).intValue();
        getEntityManager().getTransaction().commit();
        return returnvalue;
    }

    @Override
    public void deleteDriver(int driverId) {
        getEntityManager().getTransaction().begin();
        getEntityManager().createQuery("UPDATE DrivercareinstitutionEntity SET DrivercareinstitutionEntity.active = false " +
                "WHERE DrivercareinstitutionEntity.driverId = :driverId").setParameter("driverId", driverId).getResultList();
        getEntityManager().getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DriverEntity> getByCareInstitutionId(int id) {
        List<DriverEntity> driverEntities = new ArrayList<>();
        try {
            List<DrivercareinstitutionEntity> drivercareinstitutionEntities = getEntityManager().createQuery("FROM DrivercareinstitutionEntity " +
                    "WHERE careInstitutionId = :id").setParameter("id", id).getResultList();

            for (int i = 0; i < drivercareinstitutionEntities.size(); i++) {
                driverEntities.add(findById(drivercareinstitutionEntities.get(i).getDriverId()));
            }
        } catch (NullPointerException e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return driverEntities;
    }
}

