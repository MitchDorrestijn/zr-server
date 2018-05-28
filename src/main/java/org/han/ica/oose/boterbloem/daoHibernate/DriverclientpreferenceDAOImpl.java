package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.entity.DriverclientpreferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DriverclientpreferenceDAOImpl extends GenericDAOImpl<DriverclientpreferenceEntity> implements IDriverclientpreferenceDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DriverclientpreferenceDAOImpl() {
        super(DriverclientpreferenceEntity.class);
    }
}
