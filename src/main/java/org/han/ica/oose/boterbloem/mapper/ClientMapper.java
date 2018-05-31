package org.han.ica.oose.boterbloem.mapper;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.entity.RideEntity;
import org.han.ica.oose.boterbloem.service.displays.ClientDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientMapper {
    private static final Logger LOGGER = Logger.getLogger(ClientMapper.class.getName());

    private IClientDAO clientDAO = new ClientDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();
    private IClientcareinstitutionDAO clientCareInstitutionDAO = new ClientcareinstitutionDAOImpl();

    /**
     * Gets all the clients from all care institutions
     * @return method returns a list of all found clients
     */
    public List <ClientDisplay> getAllClients(){
        List <ClientDisplay> clientDisplays = new ArrayList <>();
        try {
            for (ClientEntity c : clientDAO.findAll()) {
                ClientDisplay client = fillClientDisplay(c);
                clientDisplays.add(client);
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return clientDisplays;
    }

    /**
     * Get all the clients from a specific care institution
     * @return a list of information from the clients of a specific care institution
     */
    public List<ClientDisplay> getAllClientsFromASpecificCareInstitution(int id){
        List <ClientDisplay> clientDisplays = new ArrayList <>();
        try {
            for (ClientEntity c : clientDAO.getByCareInstitutionId(id)) {
                ClientDisplay client = fillClientDisplay(c);
                clientDisplays.add(client);
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return clientDisplays;
    }

    /**
     * @param c - The clientEntity
     * @return A filled clientDisplay
     */
    private ClientDisplay fillClientDisplay(ClientEntity c) {
        int clientId = c.getClientId();
        ClientDisplay client = new ClientDisplay();
        double priceToPay;
        boolean warningPKB;
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
                final double DISTANCE_MULTIPLIER = 0.005;
                priceToPay = (distance * DISTANCE_MULTIPLIER);
                warningPKB = true;
                client.setTotalMeters(distance);
                client.setPriceToPay(priceToPay);
                client.setWarningPKB(warningPKB);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return client;
    }

}
