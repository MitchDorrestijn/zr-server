package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.DriverDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.display.displayobject.ClientRideDisplay;
import org.han.ica.oose.boterbloem.service.IClientRideService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRideService implements IClientRideService {
    private IRideDAO rideDAO = new RideDAOImpl();
    private IClientDAO clientDAO = new ClientDAOImpl();

    private static final Logger LOGGER = Logger.getLogger(ClientRideService.class.getName());


    @Override
    public List<ClientRideDisplay> getRidesFromSpecificClient(int clientId) {
        List<ClientRideDisplay> clientRideDisplays = new ArrayList<>();
        try {
            for (RideEntity rideEntity : rideDAO.getByClient(clientId)) {
                ClientRideDisplay display = new ClientRideDisplay();
                display.setDate(rideEntity.getPickUpDateTime());
                display.setPickupLocation(rideEntity.getPickUpLocation());
                display.setDestination(rideEntity.getDropOffLocation());
                display.setClientName(clientDAO.findById(clientId).getUserEntity().getFirstName() + " " + clientDAO.findById(clientId).getUserEntity().getLastName());
                try {
                    display.setDriverName(rideEntity.getDriverEntity().getUserEntity().getFirstName() + " " + rideEntity.getDriverEntity().getUserEntity().getLastName());
                } catch (NullPointerException e) {
                    LOGGER.log(Level.WARNING, e.toString(), e);
                    display.setDriverName("Geen chauffeur gevonden");
                }
                clientRideDisplays.add(display);
            }
            return clientRideDisplays;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return new ArrayList<>();
    }
}
