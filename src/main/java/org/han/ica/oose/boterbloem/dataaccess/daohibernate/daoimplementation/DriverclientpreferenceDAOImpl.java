package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriverclientpreferenceDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.GenericDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverclientpreferenceEntity;

public class DriverclientpreferenceDAOImpl extends GenericDAOImpl<DriverclientpreferenceEntity> implements IDriverclientpreferenceDAO {

    /**
     * Hook up the basic CRUD queries
     */

    public DriverclientpreferenceDAOImpl() {
        super(DriverclientpreferenceEntity.class);
    }
}
