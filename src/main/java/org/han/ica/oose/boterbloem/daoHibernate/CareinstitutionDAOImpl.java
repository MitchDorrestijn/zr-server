package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.CareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class CareinstitutionDAOImpl extends GenericDAOImpl<CareinstitutionEntity> implements ICareinstitutionDAO {

    /**
     * Hook up the basic CRUD queries
     * @param em [provided] - runs querys
     */
    @Autowired
    public CareinstitutionDAOImpl(EntityManager em) {
        super(em, CareinstitutionEntity.class);
    }
}
