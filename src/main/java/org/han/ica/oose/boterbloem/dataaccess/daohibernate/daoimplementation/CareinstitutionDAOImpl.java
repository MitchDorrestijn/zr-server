package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
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