package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.LimitationEntity;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;
import org.han.ica.oose.boterbloem.service.projection.RatingsDisplay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class LimitationService implements ILimitationService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private LimitationDAOImpl limitationDAO = new LimitationDAOImpl(entityManager);

    public LimitationService() {
        //Empty constructor
    }

    /**
     * @return A list of all ratings from the database
     */

    public List<LimitationEntity> getAllLimitations() {
        return limitationDAO.findAll();
    }
}
