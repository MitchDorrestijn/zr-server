//package org.han.ica.oose.boterbloem.service;
//
//
//        import org.han.ica.oose.boterbloem.daoHibernate.*;
//        import org.han.ica.oose.boterbloem.domain.Driver;
//        import org.han.ica.oose.boterbloem.domain.Ride;
//        import org.han.ica.oose.boterbloem.entity.RideEntity;
//        import org.han.ica.oose.boterbloem.service.projection.DriverDisplay;
//
//        import javax.persistence.EntityManager;
//        import javax.persistence.EntityManagerFactory;
//        import javax.persistence.Persistence;
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class DriverService implements IDriverService {
//
//
//    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
//    private EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//    private IDriverDAO driverDao = new DriverDAOImpl(entityManager);
//    private IRideDAO rideDAO = new RideDAOImpl(entityManager);
//    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl(entityManager);
//    private IRatingsDAO ratingsDAO = new RatingsDAOImpl(entityManager);
//    private IUserDAO userDAO = new UserDAOImpl(entityManager);
//
//    private DriverDisplay
//
//    public DriverService() {
//        //Empty constructor
//    }
//
//    /***
//     * @return A list of all chauffeurs and their properties
//     */
//    @Override
//    public List<Driver> getAllDrivers() {
//
//        return driverDAO.getAllDrivers();
//    }
//}