package org.han.ica.oose.boterbloem.mapper;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.service.displays.DriverDisplay;

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

    /**
     * @param id id of the careInstitution
     * @return A list of drivers from a specifec care institution
     */
    public List<DriverDisplay> getAllDriversFromASpecificCareInstitution(int id){
        List<DriverDisplay> returnList = new ArrayList<>();
        try {
            for(DriverEntity d : driverDAO.getByCareInstitutionId(id)){
                int driverId = d.getDriverId();
                DriverDisplay driver = new DriverDisplay();
                driver.setId(driverId);
                driver.setName(d.getUserEntity().getFirstName() + " " + d.getUserEntity().getLastName());
                driver.setTypeOfPayment(d.getTypeOfPayment());
                try {
                    if (drivercarDAO.findCarById(driverId) == null) {
                        driver.setNumberOfPassengers(0);
                        driver.setNumberPlate("Geen nummerplaat gevonden");
                    } else {
                        driver.setNumberOfPassengers(drivercarDAO.findCarById(driverId).getNumberOfPassengers());
                        driver.setNumberPlate(drivercarDAO.findCarById(driverId).getNumberPlate());
                    }
                } catch (Exception e) {
                    LOGGER.log(Level.WARNING, e.toString(), e);
                }
                driver.setRating(ratingsDAO.getAvgRatings(driverId));
                driver.setSegment(driver.getSegment());
                driver.setTotalEarned(rideDAO.totalEarned(driverId));
                driver.setTotalRides(rideDAO.rideCountById(driverId));

                returnList.add(driver);
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return returnList;
    }

}
