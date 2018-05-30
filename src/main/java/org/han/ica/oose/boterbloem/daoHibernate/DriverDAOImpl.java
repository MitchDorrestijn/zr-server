package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainImplementation.Driver;
import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.DrivercareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DriverDAOImpl extends GenericDAOImpl<DriverEntity> implements IDriverDAO {

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
        List<DrivercareinstitutionEntity> drivercareinstitutionEntities = getEntityManager().createQuery("FROM DrivercareinstitutionEntity " +
                "WHERE careInstitutionId = :id").setParameter("id", id).getResultList();

        List<DriverEntity> driverEntities = new ArrayList<>();
        for(int i = 0; i < drivercareinstitutionEntities.size(); i++) {
            driverEntities.add(findById(drivercareinstitutionEntities.get(i).getDriverId()));
        }
        return driverEntities;
    }
}

