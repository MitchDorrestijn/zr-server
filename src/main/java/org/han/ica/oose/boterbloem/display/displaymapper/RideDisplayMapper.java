package org.han.ica.oose.boterbloem.display.displaymapper;

import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RidesByCareinstitutionDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.RideMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Ride;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RideDisplayMapper {
    private static final Logger LOGGER = Logger.getLogger(RideDisplayMapper.class.getName());
    private RideMapper rideMapper = new RideMapper();

    public void updateRide(CreateRideDisplay rideDisplay) {
        Ride ride = rideMapper.getRide(rideDisplay);
        rideMapper.updateRide(ride);
    }

    public List<RidesByCareinstitutionDisplay> getAllRidesByInstitution(int careId) {
        List<Ride> rides = rideMapper.getAllRidesByInstitution(careId);
        List<RidesByCareinstitutionDisplay> ridesByCareinstitutionDisplays = new ArrayList<>();
        try {
            for (Ride ride : rides) {
                RidesByCareinstitutionDisplay ridesByCareinstitutionDisplay = new RidesByCareinstitutionDisplay();
                ridesByCareinstitutionDisplay.setClientName(ride.getClient().getFirstName() + " " + ride.getClient().getLastName());
                ridesByCareinstitutionDisplay.setDriverName(ride.getDriver().getFirstName() + " " + ride.getDriver().getLastName());
                ridesByCareinstitutionDisplay.checkIfDriverAssigned();
                ridesByCareinstitutionDisplay.setDropOfLocation(ride.getDropOffLocation());
                ridesByCareinstitutionDisplay.setPickUpDateTime(ride.getPickUpDateTime());
                ridesByCareinstitutionDisplay.setPickUpLocation(ride.getPickUpLocation());
                ridesByCareinstitutionDisplays.add(ridesByCareinstitutionDisplay);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return ridesByCareinstitutionDisplays;
    }
}
