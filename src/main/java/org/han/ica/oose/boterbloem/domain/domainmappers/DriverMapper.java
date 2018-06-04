package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDrivercarDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRatingsDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.DriverDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.DrivercarDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RatingsDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;
import org.han.ica.oose.boterbloem.domain.domainobjects.DriverCar;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverMapper {
    private static final Logger LOGGER = Logger.getLogger(DriverMapper.class.getName());

    private IDriverDAO driverDAO = new DriverDAOImpl();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();

    private DriverCarMapper driverCarMapper = new DriverCarMapper();

    /**
     * @param id id of the careInstitution
     * @return A list of drivers from a specific care institution
     */
    public List<DriverDisplay> getAllDriversFromASpecificCareInstitution(int id) {
        List<DriverDisplay> returnList = new ArrayList<>();
        try {
            for (DriverEntity d : driverDAO.getByCareInstitutionId(id)) {
                DriverDisplay driver = fillDriverDisplay(d);
                returnList.add(driver);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return returnList;
    }

    /**
     * @return A list of all drivers from all care institutions
     */
    public List<DriverDisplay> allDriversWithStatistics() {
        List<DriverDisplay> returnList = new ArrayList<>();
        try {
            for (DriverEntity d : driverDAO.findAll()) {
                DriverDisplay driver = fillDriverDisplay(d);
                returnList.add(driver);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return returnList;
    }

    /**
     * @param d - The DriverEntity
     * @return a filled DriverDisplay
     */
    private DriverDisplay fillDriverDisplay(DriverEntity d) {
        int driverId = d.getDriverId();
        DriverDisplay driver = new DriverDisplay();
        driver.setId(driverId);
        driver.setName(d.getUserEntity().getFirstName() + " " + d.getUserEntity().getLastName());
        driver.setTypeOfPayment(d.getTypeOfPayment());
        try {
            if (drivercarDAO.findCarById(driverId) == null) {
                driver.getDriverCar().setNumberOfPassengers(0);
                driver.getDriverCar().setNumberPlate("Geen nummerplaat gevonden");
            } else {
                driver.getDriverCar().setNumberOfPassengers(drivercarDAO.findCarById(driverId).getNumberOfPassengers());
                driver.getDriverCar().setNumberPlate(drivercarDAO.findCarById(driverId).getNumberPlate());
            }
            driver.setRating(ratingsDAO.getAvgRatings(driverId));
            driver.getDriverCar().setSegment(driver.getDriverCar().getSegment());
            driver.setTotalEarned(rideDAO.totalEarned(driverId));
            driver.setTotalRides(rideDAO.rideCountById(driverId));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return driver;
    }

    public Driver extractDriver(DriverEntity driverEntity) {
        Driver driver = new Driver();

        driver.setVerification(driverEntity.getVerification());
        driver.setTypeOfPayment(driverEntity.getTypeOfPayment());
        driver.setImage(driverEntity.getImage());
        driver.setAccountnr(driverEntity.getAccountnr());
        driver.setDriverCars(setDriverCarsByDriverId(driverEntity.getDriverId()));
        driver.setTotalEarned(rideDAO.totalEarned(driverEntity.getDriverId()));
        driver.setTotalRides(rideDAO.totalRideClient(driverEntity.getDriverId()));

        return driver;
    }

    public DriverEntity convertDriver(Driver driver) {
        DriverEntity driverEntity = new DriverEntity();
        driverEntity.setDriverId(driver.getId());
        driverEntity.setVerification(driver.getVerification());
        driverEntity.setImage(driver.getImage());
        driverEntity.setAccountnr(driver.getAccountnr());
        for(DriverCar driverCar : setDriverCarsByDriverId(driver.getId())) {
            drivercarDAO.update(driverCarMapper.convertDriverCar(driverCar));
        }
        return driverEntity;
    }

    /**
     * Set the driverCars of a driver
     *
     * @param driverId id of the driver
     * @return List of drivercars
     */
    private List<DriverCar> setDriverCarsByDriverId(int driverId) {
        List<DriverCar> driverCars = new ArrayList<>();
        for (DrivercarEntity driverCarEntity : drivercarDAO.drivercarEntityListByDriverId(driverId)) {
            driverCars.add(driverCarMapper.extractDriverCar(driverCarEntity));
        }
        return driverCars;
    }
}
