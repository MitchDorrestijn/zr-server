package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.service.displays.DriverRideDisplay;

import java.util.List;

public interface IDriverRideService {
    /**
     * @param driverId of Driver
     * @return list of driver rides
     */
    List <DriverRideDisplay> getRidesFromSpeficDriver(int driverId);
}
