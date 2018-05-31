package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dataAccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.service.displays.CreateRideDisplay;
import org.han.ica.oose.boterbloem.service.displays.RideDisplay;
import org.han.ica.oose.boterbloem.display.displayObject.RideOverviewDisplay;

import java.util.List;

public interface IRideService {
    /**
     * GET Ride by Id
     * @param id of Ride
     * @return Ride
     */
    RideEntity findById(int id);

    /**
     * GET all Rides
     * @return list of Rides
     */
    List <RideDisplay> getAllRides();

    /**
     * GET information of Rides
     * @return A list with information of a ride
     */
    List<RideOverviewDisplay> getRideOverview();

    /**
     * CREATE new Ride
     * @param createRideDisplay = Ride
     */
    void createRide(CreateRideDisplay createRideDisplay);

    /**
     * DELETE Ride by Id
     * @param id
     */
    void deleteRideById(int id);
}
