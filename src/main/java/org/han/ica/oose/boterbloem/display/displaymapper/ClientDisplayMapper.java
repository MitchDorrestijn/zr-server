package org.han.ica.oose.boterbloem.display.displaymapper;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDisplayMapper {
    private static final Logger LOGGER = Logger.getLogger(ClientDisplayMapper.class.getName());

    private IClientDAO clientDAO = new ClientDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();
    private static final double DISTANCE_MULTIPLIER = 0.005;

    /**
     * Gets all the clients from all care institutions
     *
     * @return method returns a list of all found clients
     */
    public List<ClientDisplay> getAllClients() {
        List<ClientDisplay> clientDisplays = new ArrayList<>();
        try {
            for (ClientEntity c : clientDAO.findAll()) {
                ClientDisplay client = fillClientDisplay(c);
                clientDisplays.add(client);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return clientDisplays;
    }

    /**
     * Get all the clients from a specific care institution
     *
     * @return a list of information from the clients of a specific care institution
     */
    public List<ClientDisplay> getAllClientsFromASpecificCareInstitution(int id) {
        List<ClientDisplay> clientDisplays = new ArrayList<>();
        try {
            for (ClientEntity c : clientDAO.getByCareInstitutionId(id)) {
                ClientDisplay client = fillClientDisplay(c);
                clientDisplays.add(client);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return clientDisplays;
    }

    /**
     * @param c - The clientEntity
     * @return A filled clientDisplay
     */
    public ClientDisplay fillClientDisplay(ClientEntity c) {
        int clientId = c.getClientId();
        ClientDisplay client = new ClientDisplay();
        double priceToPay;
        int distance = 0;
        List<RideEntity> rideEntitiesPerClient = rideDAO.getByClient(clientId);
        for (RideEntity rideEntity : rideEntitiesPerClient) {
            distance += rideEntity.getDistance();
        }
        client.setClientId(c.getClientId());
        client.setName(c.getUserEntity().getFirstName() + " " + c.getUserEntity().getLastName());
        client.setPKB(c.getPKB());
        try {
            if (distance > c.getPKB()) {
                //This is for rounding off the price to 2 decimals
                priceToPay = (double)Math.round((distance * DISTANCE_MULTIPLIER) * 100) / 100;
                client.setTotalMeters(distance);
                client.setPriceToPay(priceToPay);
                client.setWarningPKB(true);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return client;
    }

    /**
     * Getter for property 'clientDAO'.
     *
     * @return Value for property 'clientDAO'.
     */
    public IClientDAO getClientDAO() {
        return clientDAO;
    }

    /**
     * Setter for property 'clientDAO'.
     *
     * @param clientDAO Value to set for property 'clientDAO'.
     */
    public void setClientDAO(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    /**
     * Getter for property 'rideDAO'.
     *
     * @return Value for property 'rideDAO'.
     */
    public IRideDAO getRideDAO() {
        return rideDAO;
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
