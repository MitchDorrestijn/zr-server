package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.DriverlimitationmanageableEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriverLimitationManageableDAOImpl extends GenericDAOImpl<DriverlimitationmanageableEntity> implements IDriverLimitationManageableDAOm {

    @Autowired
    public DriverLimitationManageableDAOImpl(EntityManager em) {
        super(em, DriverlimitationmanageableEntity.class);
    }
}
