package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.CareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class CareinstitutionDAOImpl extends GenericDAOImpl<CareinstitutionEntity> implements ICareinstitutionDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public CareinstitutionDAOImpl() {
        super(CareinstitutionEntity.class);
    }
}