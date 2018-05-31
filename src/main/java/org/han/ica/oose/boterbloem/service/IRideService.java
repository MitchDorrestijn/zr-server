package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.service.displays.CreateRideDisplay;
import org.han.ica.oose.boterbloem.service.displays.RideDisplay;

import java.util.List;

public interface IRideService {
    /**
     * @return list of all rides
     */
    List <RideDisplay> getAllRides();

    /**
     * @param createRideDisplay = create a ride for a Client
     */
    void createRide(CreateRideDisplay createRideDisplay);

    /**
     * deletes a ride based on the given int
     * @param id of ride
     */
    void deleteRide(int id);
}
