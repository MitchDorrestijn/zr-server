package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.RideEntity;
import org.han.ica.oose.boterbloem.service.displays.ClientRideDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRideService {
    private IRideDAO rideDAO = new RideDAOImpl();
    private IClientDAO clientDAO = new ClientDAOImpl();
    private IDriverDAO driverDAO = new DriverDAOImpl();

    private static final Logger LOGGER = Logger.getLogger(ClientRideService.class.getName());


    public List<ClientRideDisplay> getRidesFromSpecificClient(int clientId) {
        List<ClientRideDisplay> clientRideDisplays = new ArrayList<>();
        try {
            for(RideEntity rideEntity : rideDAO.getByClient(clientId)) {
                ClientRideDisplay display = new ClientRideDisplay();
                display.setDate(rideEntity.getPickUpDateTime());
                display.setPickupLocation(rideEntity.getPickUpLocation());
                display.setDestination(rideEntity.getDropOffLocation());
                display.setClientName(clientDAO.findById(clientId).getUserEntity().getFirstName() + " " + clientDAO.findById(clientId).getUserEntity().getLastName());
                try {
                    display.setDriverName(rideEntity.getDriverEntity().getUserEntity().getFirstName() + " " + rideEntity.getDriverEntity().getUserEntity().getLastName());
                } catch(NullPointerException e) {
                    LOGGER.log(Level.WARNING, e.toString(), e);
                    display.setDriverName("Geen chauffeur gevonden");
                }
                clientRideDisplays.add(display);
            }
            return clientRideDisplays;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return null;
    }
}
