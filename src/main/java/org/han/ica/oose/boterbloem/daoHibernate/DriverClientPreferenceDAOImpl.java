package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.DriverclientpreferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriverClientPreferenceDAOImpl extends GenericDAOImpl<DriverclientpreferenceEntity> implements IDriverClientPreferenceDAOm {

    @Autowired
    public DriverClientPreferenceDAOImpl(EntityManager em) {
        super(em, DriverclientpreferenceEntity.class);
    }
}
