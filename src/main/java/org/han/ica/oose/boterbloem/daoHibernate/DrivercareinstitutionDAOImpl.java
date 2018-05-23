package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.entity.DrivercareinstitutionEntity;
import org.han.ica.oose.boterbloem.entity.DrivercareinstitutionEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class DrivercareinstitutionDAOImpl extends GenericDAOImpl<DrivercareinstitutionEntity> implements IDrivercareinstitutionDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public DrivercareinstitutionDAOImpl(EntityManager em) {
        super(em, DrivercareinstitutionEntity.class);
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
    public int getDriverCareinstitutionId(int id) {
        return ((int) getEntityManager().createQuery("select careInstitutionId from DrivercareinstitutionEntity where driverId = :id").setParameter("id", id).getSingleResult());
    }

    public DrivercareinstitutionEntity findById(DrivercareinstitutionEntity drivercareinstitutionEntity){
        return getEntityManager().find(DrivercareinstitutionEntity.class, drivercareinstitutionEntity);
    }
}
