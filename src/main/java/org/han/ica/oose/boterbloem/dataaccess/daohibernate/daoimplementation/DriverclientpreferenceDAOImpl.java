package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriverclientpreferenceDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverclientpreferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverclientpreferenceDAOImpl extends GenericDAOImpl<DriverclientpreferenceEntity> implements IDriverclientpreferenceDAO {

    /**
     * Hook up the basic CRUD queries
     */
    @Autowired
    public DriverclientpreferenceDAOImpl() {
        super(DriverclientpreferenceEntity.class);
    }
}
