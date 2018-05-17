package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.UtilityEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class UtilityDAOImpl extends GenericDAOImpl<UtilityEntity> implements IUtilityDAO {
    
    @Autowired
    public UtilityDAOImpl(EntityManager em) {
        super(em, UtilityEntity.class);
    }
}
