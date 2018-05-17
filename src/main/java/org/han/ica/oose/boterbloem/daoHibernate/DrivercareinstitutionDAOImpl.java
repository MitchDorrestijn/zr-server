package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.DrivercareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DrivercareinstitutionDAOImpl extends GenericDAOImpl<DrivercareinstitutionEntity> implements IDrivercareinstitutionDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public DrivercareinstitutionDAOImpl(EntityManager em) {
        super(em, DrivercareinstitutionEntity.class);
    }
}
