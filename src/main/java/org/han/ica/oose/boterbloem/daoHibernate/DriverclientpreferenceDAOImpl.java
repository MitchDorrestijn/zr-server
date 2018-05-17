package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.DriverclientpreferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriverclientpreferenceDAOImpl extends GenericDAOImpl<DriverclientpreferenceEntity> implements IDriverclientpreferenceDAO {

    @Autowired
    public DriverclientpreferenceDAOImpl(EntityManager em) {
        super(em, DriverclientpreferenceEntity.class);
    }
}
