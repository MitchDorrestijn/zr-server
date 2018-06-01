package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class CareinstitutionDAOImpl extends GenericDAOImpl<CareinstitutionEntity> implements ICareinstitutionDAO {

    /**
     * Hook up the basic CRUD queries
     */
    public CareinstitutionDAOImpl() {
        super(CareinstitutionEntity.class);
    }
}