package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.*;

import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntityPK;
import org.han.ica.oose.boterbloem.service.projection.DriverDisplay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
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

    public List<DriverDisplay> allDriversWithStatistics(){
        List<DriverDisplay> returnList =  new ArrayList<>();
        for (DriverEntity x: driverDao.findAll()) {

            DriverDisplay driver = new DriverDisplay();
            DrivercarEntityPK drivercarEntityPK = new DrivercarEntityPK();

            int driverId = x.getDriverId();
            drivercarEntityPK.setDriverId(driverId);
            drivercarEntityPK.setUtility(x.getUtility());

            driver.setId(driverId);
            driver.setName(x.getUserEntity().getFirstName() + " " + x.getUserEntity().getLastName());
            driver.setTypeOfPayment(x.getTypeOfPayment());

            if(drivercarDAO.findByPK(drivercarEntityPK) == null) {
                driver.setNumberOfPassengers(0);
                driver.setNumberPlate("");
            } else {
                driver.setNumberOfPassengers(drivercarDAO.findByPK(drivercarEntityPK).getNumberOfPassengers());
                driver.setNumberPlate(drivercarDAO.findByPK(drivercarEntityPK).getNumberPlate());
            }

            driver.setRating(ratingsDAO.getAvgRatings(driverId));
            driver.setSegment(x.getUtility());
            driver.setTotalEarned(rideDAO.totalEarned(driverId));
            driver.setTotalRides(rideDAO.rideCountById(driverId));
            returnList.add(driver);
        }
        return returnList;
    }

}