package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.RidematchesrejectedEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RidematchesrejectedDAOImpl extends GenericDAOImpl<RidematchesrejectedEntity> implements IRidematchesrejectedDAO {

    @Autowired
    public RidematchesrejectedDAOImpl(EntityManager em) {
        super(em, RidematchesrejectedEntity.class);
    }
}
