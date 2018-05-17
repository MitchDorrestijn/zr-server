package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.GenericDAOImpl;
import org.han.ica.oose.boterbloem.generatedEntity.RidematchesstateEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RidematchesstateDAOImpl extends GenericDAOImpl<RidematchesstateEntity> implements IRidematchesstateDAO {

    @Autowired
    public RidematchesstateDAOImpl(EntityManager em) {
        super(em, RidematchesstateEntity.class);
    }
}
