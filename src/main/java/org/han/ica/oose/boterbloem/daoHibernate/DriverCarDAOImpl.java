package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.DrivercarEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriverCarDAOImpl extends GenericDAOImpl<DrivercarEntity> implements IDriverCarDAOm {

    @Autowired
    public DriverCarDAOImpl(EntityManager em) {
        super(em, DrivercarEntity.class);
    }
}
