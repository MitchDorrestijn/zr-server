package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.daoHibernate.IUserDAO;
import org.han.ica.oose.boterbloem.daoHibernate.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.UserDAOImpl;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;
import org.han.ica.oose.boterbloem.service.projection.RatingsDisplay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class RatingsService implements IRatingsService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private IRatingsDAO ratingsDAO  = new RatingsDAOImpl();
    private IUserDAO userDAO = new UserDAOImpl();

    public RatingsService() {
        //Empty constructor
    }

    /**
     * @return A list of all ratings from the database
     */

    public List<RatingsDisplay> getAllRatings() {
        List<RatingsDisplay> ratingsDisplays = new ArrayList<>();
        List<RatingsEntity> ratingsEntities = ratingsDAO.findAll();
        for (RatingsEntity i : ratingsEntities) {
            RatingsDisplay ratingsDisplay = new RatingsDisplay();
            ratingsDisplay.setBeoordeling(i.getBeoordeling());
            ratingsDisplay.setClientId(i.getClientId());
            ratingsDisplay.setClientName(userDAO.findById(i.getClientId()).getFirstName());
            ratingsDisplay.setDriverId(i.getDriverId());
            ratingsDisplay.setDriverName(userDAO.findById(i.getDriverId()).getFirstName());
            ratingsDisplay.setSterren(i.getSterren());
            ratingsDisplays.add(ratingsDisplay);
        }
        return ratingsDisplays;
    }
}
