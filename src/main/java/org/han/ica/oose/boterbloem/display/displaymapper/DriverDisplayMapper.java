package org.han.ica.oose.boterbloem.display.displaymapper;

import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.RatingsMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Driver;

public class DriverDisplayMapper {
    private RatingsMapper ratingsMapper = new RatingsMapper();

    public DriverDisplay fillDisplay(Driver driver) {
        DriverDisplay driverDisplay = new DriverDisplay();
        driverDisplay.setId(driver.getId());
        driverDisplay.setName(driver.getFirstName() + " " + driver.getLastName());
        driverDisplay.setTypeOfPayment(driver.getTypeOfPayment());
        driverDisplay.setTotalEarned(driver.getTotalEarned());
        driverDisplay.setTotalRides(driver.getTotalRides());
        driverDisplay.setRating(ratingsMapper.getAvgRating(driver.getId()));

        return driverDisplay;
    }
}
