package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.RidecanceledbydriverEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RideCanceledByDriverDAOImpl extends GenericDAOImpl<RidecanceledbydriverEntity> implements IRideCanceledByDriverDAOm {

    @Autowired
    public RideCanceledByDriverDAOImpl(EntityManager em) {
        super(em, RidecanceledbydriverEntity.class);
    }
}
