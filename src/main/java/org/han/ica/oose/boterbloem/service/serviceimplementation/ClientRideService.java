package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.service.IClientRideService;
import org.han.ica.oose.boterbloem.display.displayobject.ClientRideDisplay;

import java.util.*;
import java.util.logging.*;

public class ClientRideService implements IClientRideService {
    private static final Logger LOGGER = Logger.getLogger(ClientRideService.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();
    private IClientDAO clientDAO = new ClientDAOImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public List <ClientRideDisplay> getRidesFromSpecificClientById(int id) {
        List <ClientRideDisplay> clientRideDisplays = new ArrayList <>();
        try {
            for (RideEntity rideEntity : rideDAO.getByClient(id)) {
                ClientRideDisplay display = new ClientRideDisplay();
                display.setDate(rideEntity.getPickUpDateTime());
                display.setPickupLocation(rideEntity.getPickUpLocation());
                display.setDestination(rideEntity.getDropOffLocation());
                display.setClientName(clientDAO.findById(id).getUserEntity().getFirstName() + " " +
                        clientDAO.findById(id).getUserEntity().getLastName());
                try {
                    display.setDriverName(rideEntity.getDriverEntity().getUserEntity().getFirstName() + " " +
                            rideEntity.getDriverEntity().getUserEntity().getLastName());
                } catch ( NullPointerException e ) {
                    display.setDriverName("Geen chauffeur gevonden");
                }
                clientRideDisplays.add(display);
            }
            return clientRideDisplays;
        } catch ( Exception e ) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return null;
    }
}
