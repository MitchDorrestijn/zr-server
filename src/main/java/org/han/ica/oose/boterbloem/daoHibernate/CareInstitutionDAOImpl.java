package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.CareinstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class CareInstitutionDAOImpl extends GenericDAOImpl<CareinstitutionEntity> implements ICareInstitutionDAOm {

    @Autowired
    public CareInstitutionDAOImpl(EntityManager em) {
        super(em, CareinstitutionEntity.class);
    }
}
