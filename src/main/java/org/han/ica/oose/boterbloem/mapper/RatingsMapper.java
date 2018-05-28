package org.han.ica.oose.boterbloem.mapper;

import org.han.ica.oose.boterbloem.daoHibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.daoHibernate.IUserDAO;
import org.han.ica.oose.boterbloem.daoHibernate.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.UserDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainImplementation.Ratings;
import org.han.ica.oose.boterbloem.entity.RatingsEntity;

import java.util.ArrayList;
import java.util.List;

public class RatingsMapper {

    private IUserDAO userDAO = new UserDAOImpl();
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();

    public List<Ratings> ratingByDriver() {
        return new ArrayList<>();
    }

    public List<Ratings> ratingByClient() {
        return new ArrayList<>();
    }

    public List<Ratings> allRatings() {
        List<Ratings> ratings = new ArrayList<>();
        for (RatingsEntity r : ratingsDAO.findAll()) {
            Ratings rating = new Ratings();
            rating.setClientName(findNameByRating(r.getClientId()));
            rating.setDriverName(findNameByRating(r.getDriverId()));
            rating.setStars(r.getSterren());
            rating.setComment(r.getBeoordeling());
            ratings.add(rating);
        }
        return ratings;
    }

    private String findNameByRating(int id) {
        return userDAO.findById(id).getFirstName() + userDAO.findById(id).getLastName();
    }

}
