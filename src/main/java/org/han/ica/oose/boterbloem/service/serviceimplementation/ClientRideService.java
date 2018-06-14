package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
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
    public List<ClientRideDisplay> getRidesFromSpecificClientById(int clientId) {
        List<ClientRideDisplay> clientRideDisplays = new ArrayList<>();
        try {
            for (RideEntity rideEntity : rideDAO.getByClient(clientId)) {
                ClientRideDisplay display = setClientRideDisplay(clientId, rideEntity);
                clientRideDisplays.add(display);
            }
            return clientRideDisplays;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return new ArrayList<>();
    }

    private ClientRideDisplay setClientRideDisplay(int clientId, RideEntity rideEntity) {
        ClientRideDisplay display = new ClientRideDisplay();
        display.setDate(rideEntity.getPickUpDateTime());
        display.setPickupLocation(rideEntity.getPickUpLocation());
        display.setDestination(rideEntity.getDropOffLocation());
        display.setClientName(clientDAO.findById(clientId).getUserEntity().getFirstName() + " " + clientDAO.findById(clientId).getUserEntity().getLastName());
        try {
            display.setDriverName(rideEntity.getDriverEntity().getUserEntity().getFirstName() + " " + rideEntity.getDriverEntity().getUserEntity().getLastName());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
            display.setDriverName("Geen chauffeur gevonden");
        }
        return display;
    }

    /**
     * Setter for property 'rideDAO'.
     *
     * @param rideDAO Value to set for property 'rideDAO'.
     */
    public void setRideDAO(IRideDAO rideDAO) {
        this.rideDAO = rideDAO;
    }

    /**
     * Setter for property 'clientDAO'.
     *
     * @param clientDAO Value to set for property 'clientDAO'.
     */
    public void setClientDAO(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
}
