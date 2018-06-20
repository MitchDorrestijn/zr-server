package org.han.ica.oose.boterbloem.display.displaymapper;

import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
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

    /**
     * finds all the rides with a driver or client who is assigned to a carinstitution
     *
     * @param careId of the careinstitution
     * @return list of display's
     */
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

    /**
     * payments of a specific careisntitution
     *
     * @param id of a careinstitution
     * @return display of Payments
     */
    public List<RideOverviewDisplay> getPaymentsAtCareinstitution(int id) {
        List<Ride> rides = rideMapper.getAllRidesByInstitution(id);
        List<RideOverviewDisplay> rideOverviewDisplays = new ArrayList<>();
        for (Ride ride : rides) {
            RideOverviewDisplay rideOverviewDisplay = new RideOverviewDisplay();
            rideOverviewDisplay.setpriceOfRide(ride.getPriceOfRide());
            if (ride.getDriver() == null) {
                rideOverviewDisplay.setId(0);
                rideOverviewDisplay.setDriverName("");
                rideOverviewDisplay.setAccountnr("");
            } else {
                rideOverviewDisplay.setId(ride.getDriver().getId());
                rideOverviewDisplay.setDriverName(ride.getDriver().getFirstName() + " " + ride.getDriver().getLastName());
                rideOverviewDisplay.setAccountnr(ride.getDriver().getAccountnr());
            }
            rideOverviewDisplay.setPaymentDescription(ride.getPaymentDescription());
            rideOverviewDisplay.setPaymentDueBefore((ride.getPaymentDueBefore()));
            rideOverviewDisplay.setPaymentStatus(ride.getPaymentStatus());
            rideOverviewDisplays.add(rideOverviewDisplay);
        }
        return rideOverviewDisplays;

    }

    /**
     * Setter for property 'rideMapper'.
     *
     * @param rideMapper Value to set for property 'rideMapper'.
     */
    public void setRideMapper(RideMapper rideMapper) {
        this.rideMapper = rideMapper;
    }
}
