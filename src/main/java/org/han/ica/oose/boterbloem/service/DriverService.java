package org.han.ica.oose.boterbloem.service;


        import org.han.ica.oose.boterbloem.daoHibernate.*;

        import org.han.ica.oose.boterbloem.entity.DriverEntity;
        import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
        import org.springframework.beans.factory.annotation.Autowired;

        import javax.persistence.EntityManager;
        import javax.persistence.EntityManagerFactory;
        import javax.persistence.Persistence;

        import java.util.List;

public class DriverService implements IDriverService {


    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private IDriverDAO driverDao = new DriverDAOImpl(entityManager);
    private IRideDAO rideDAO = new RideDAOImpl(entityManager);
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl(entityManager);
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl(entityManager);
    private IUserDAO userDAO = new UserDAOImpl(entityManager);



    public DriverService() {
        //Empty constructor
    }

    /***
     * @return A list of all chauffeurs and their properties
     */
    @Override
    public List<DrivercarEntity> getAllDrivers() {

        return drivercarDAO.findAll();
    }

    @Override
    public void deleteDriver(int id) {
        DriverEntity entity = driverDao.findById(id);
        driverDao.update(entity);
    }

//    public List<DriverDisplay> allDriversWithStatistics(){
//        List<DriverDisplay> returnList =  new ArrayList<>();
//        for (DriverEntity x: driverDao.findAll()) {
//            DriverDisplay driver = new DriverDisplay();
//            int driverId = x.getDriverId();
//            driver.setId(driverId);
//            driver.setName(x.getUserEntity().getFirstName() + " " + x.getUserEntity().getLastName());
//            driver.setTypeOfPayment(x.getTypeOfPayment());
//            driver.
//
//        }
//        DriverDisplay driverDisplay = new DriverDisplay();
//        driverDisplay.setName(drivercarDAO.);
//    }

}