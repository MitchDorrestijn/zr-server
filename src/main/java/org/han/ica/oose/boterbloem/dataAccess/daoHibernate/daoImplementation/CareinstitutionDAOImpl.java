package org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.CareinstitutionEntity;
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