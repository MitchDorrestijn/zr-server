package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.display.displayobject.DriverRideDisplay;
import org.han.ica.oose.boterbloem.service.IDriverRideService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DriverRideService implements IDriverRideService {
    private static final Logger LOGGER = Logger.getLogger(DriverRideService.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public List <DriverRideDisplay> getRidesFromSpecificDriverId(int id) {
        List<DriverRideDisplay> driverRideDisplay = new ArrayList<>();
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
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return driverRideDisplay;
    }

    /**
     * Setter for property 'rideDAO'.
     *
     * @param rideDAO Value to set for property 'rideDAO'.
     */
    public void setRideDAO(IRideDAO rideDAO) {
        this.rideDAO = rideDAO;
    }
}
