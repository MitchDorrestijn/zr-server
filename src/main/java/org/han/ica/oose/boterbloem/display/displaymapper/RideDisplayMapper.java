package org.han.ica.oose.boterbloem.display.displaymapper;

import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.RideMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Ride;

public class RideDisplayMapper {
    RideMapper rideMapper = new RideMapper();

    public void updateRide(CreateRideDisplay rideDisplay) {
        Ride ride = rideMapper.getRide(rideDisplay);
        rideMapper.updateRide(ride);
    }
}
