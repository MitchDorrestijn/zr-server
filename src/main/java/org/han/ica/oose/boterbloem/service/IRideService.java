package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.service.displays.RideDisplay;

import java.util.List;

public interface IRideService {
    /**
     * @return list of all rides
     */
    List <RideDisplay> getAllRides();

    /**
     * deletes a ride based on the given int
     * @param id
     */
    void deleteRide(int id);
}
