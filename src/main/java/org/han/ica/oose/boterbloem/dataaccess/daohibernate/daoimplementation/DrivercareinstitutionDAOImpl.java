package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDrivercareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;

public class DrivercareinstitutionDAOImpl extends GenericDAOImpl<DrivercareinstitutionEntity> implements IDrivercareinstitutionDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DrivercareinstitutionDAOImpl() {
        super(DrivercareinstitutionEntity.class);
    }

    public DrivercareinstitutionEntity find(DrivercareinstitutionEntityPK drivercareinstitutionEntityPK){
        return getEntityManager().find(DrivercareinstitutionEntity.class, drivercareinstitutionEntityPK);
    }
    @SuppressWarnings("unchecked")

    public DrivercareinstitutionEntity getCareInstitutionId(int driverId){
            try {
                int careId;
                try {
                    careId = (int) this.getEntityManager().createQuery("SELECT careInstitutionId FROM DrivercareinstitutionEntity dr WHERE dr.driverId = :driverId").setParameter("driverId", driverId).getSingleResult();
                }catch (NoResultException e){
                    return new DrivercareinstitutionEntity();
                }
                DrivercareinstitutionEntityPK drivercareinstitutionEntityPK = new DrivercareinstitutionEntityPK();
                drivercareinstitutionEntityPK.setDriverId(driverId);
                drivercareinstitutionEntityPK.setCareInstitutionId(careId);
                return  find(drivercareinstitutionEntityPK);
            } catch(NullPointerException e){
                System.out.println("check");
                return new DrivercareinstitutionEntity();
            }
        }

    @Override
    public void updateCareInstituion(int careId, int driverId) {
        getEntityManager().createQuery("UPDATE DrivercareinstitutionEntity SET careInstitutionId = :careId WHERE driverId = :driverId").setParameter("careId",careId).setParameter("driverId",driverId).executeUpdate();
    }

    @Override
    public int getDriverCareinstitutionId(int id) {
        return ((int) getEntityManager().createQuery("select careInstitutionId from DrivercareinstitutionEntity where driverId = :id").setParameter("id", id).getSingleResult());
    }

    public DrivercareinstitutionEntity findById(DrivercareinstitutionEntity drivercareinstitutionEntity){
        return getEntityManager().find(DrivercareinstitutionEntity.class, drivercareinstitutionEntity);
    }
}
