package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.RidematchescacheEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RidematchescacheDAOImpl extends GenericDAOImpl<RidematchescacheEntity> implements IRidematchescacheDAO {

    @Autowired
    public RidematchescacheDAOImpl(EntityManager em) {
        super(em, RidematchescacheEntity.class);
    }
}
