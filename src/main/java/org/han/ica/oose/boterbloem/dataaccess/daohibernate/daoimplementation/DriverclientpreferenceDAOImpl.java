package org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

public class DriverclientpreferenceDAOImpl extends GenericDAOImpl<DriverclientpreferenceEntity> implements IDriverclientpreferenceDAO {

    /**
     * Hook up the basic CRUD queries
     */
    public DriverclientpreferenceDAOImpl() {
        super(DriverclientpreferenceEntity.class);
    }
}
