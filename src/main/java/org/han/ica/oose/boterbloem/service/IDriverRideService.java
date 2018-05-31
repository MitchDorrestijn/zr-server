package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.display.displayObject.DriverRideDisplay;

import java.util.List;

public interface IDriverRideService {
    /**
     * @param driverId of Driver
     * @return list of driver rides
     */
    List <DriverRideDisplay> getRidesFromSpecificDriverId(int driverId);
}
