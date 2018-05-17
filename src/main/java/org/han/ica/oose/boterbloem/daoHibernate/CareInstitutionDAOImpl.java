package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.CareInstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class CareInstitutionDAOImpl extends GenericDAOImpl<CareInstitutionEntity> implements ICareInstitutionDAOm {

    @Autowired
    public CareInstitutionDAOImpl(EntityManager em) {
        super(em, CareInstitutionEntity.class);
    }
}
