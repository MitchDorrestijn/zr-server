package org.han.ica.oose.boterbloem.service.serviceImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.service.IDriverRideService;
import org.han.ica.oose.boterbloem.display.displayObject.DriverRideDisplay;

import java.util.*;
import java.util.logging.*;

public class DriverRideService implements IDriverRideService {
    private static final Logger LOGGER = Logger.getLogger(DriverRideService.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public List <DriverRideDisplay> getRidesFromSpecificDriverId(int id) {
        List <DriverRideDisplay> driverRideDisplay = new ArrayList <>();
        try {
            for (RideEntity ride : rideDAO.getByDriver(id)) {
                DriverRideDisplay display = new DriverRideDisplay();
                String driverName = ride.getDriverEntity().getUserEntity().getFirstName() + " "
                        + ride.getDriverEntity().getUserEntity().getLastName();
                String clientName = ride.getClientEntity().getUserEntity().getFirstName() + " "
                        + ride.getClientEntity().getUserEntity().getLastName();

                display.setDate(ride.getPickUpDateTime());
                display.setPickUpLocation(ride.getPickUpLocation());
                display.setDropOffLocation(ride.getDropOffLocation());
                display.setTransferTo("Geen rekening gevonden.");
                display.setAmount(ride.getPriceOfRide());
                display.setDriverName(driverName);
                display.setClientName(clientName);
                driverRideDisplay.add(display);
            }
        } catch ( Exception e ) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return driverRideDisplay;
    }
}
