package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.IRideDAO;
import org.han.ica.oose.boterbloem.daoHibernate.RideDAOImpl;
import org.han.ica.oose.boterbloem.entity.RideEntity;
import org.han.ica.oose.boterbloem.service.displays.RideDisplay;

import java.util.*;
import java.util.logging.*;

public class RideService implements IRideService {
    private static final Logger LOGGER = Logger.getLogger(RideService.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();

    @Override
    public List <RideDisplay> getAllRides() {
        List <RideDisplay> rideDisplay = new ArrayList <>();
        try {
            for (RideEntity ride : rideDAO.findAll()) {
                RideDisplay display = new RideDisplay();

                display.setWarning(ride.getWarning());
                display.setDate(ride.getPickUpDateTime());
                display.setPickUpLocation(ride.getPickUpLocation());
                display.setDropOffLocation(ride.getDropOffLocation());
                display.setAssignedDriver(ride.getAssignedDriver());

                try {
                    String driverName = ride.getDriverEntity().getUserEntity().getFirstName() + " " +
                            ride.getDriverEntity().getUserEntity().getLastName();

                    String clientName = ride.getClientEntity().getUserEntity().getFirstName() + " " +
                            ride.getClientEntity().getUserEntity().getLastName();

                    display.setDriverName(driverName);
                    display.setClientName(clientName);
                } catch ( NullPointerException e ) {
                    display.setDriverName("Geen chauffeur gevonden");
                }
                rideDisplay.add(display);
            }
        } catch ( Exception e ) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return rideDisplay;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteRide(int id) {
        try {
            RideEntity rideToRemove = rideDAO.findById(id);
            rideDAO.remove(rideToRemove);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }
}
