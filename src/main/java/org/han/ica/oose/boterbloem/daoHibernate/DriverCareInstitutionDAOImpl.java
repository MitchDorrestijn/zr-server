package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.DrivercareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriverCareInstitutionDAOImpl extends GenericDAOImpl<DrivercareinstitutionEntity> implements IDriverCareInstitutionDAOm {

    @Autowired
    public DriverCareInstitutionDAOImpl(EntityManager em) {
        super(em, DrivercareinstitutionEntity.class);
    }
}
