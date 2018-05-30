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
     * Get all the clients from a specific care institution
     * @return a list of information from the clients of a specific care institution
     */
    public List<ClientDisplay> getAllClientsFromASpecificCareInstitution(int id){
        List<ClientDisplay> returnList = new ArrayList<>();
        try {
            for(ClientEntity c : clientDAO.getByCareInstitutionId(id)){
                try {
                    int clientId = c.getClientId();
                    double priceToPay;
                    boolean warningPKB;
                    List<RideEntity> rideEntitiesPerClient = rideDAO.getByClient(c.getClientId());
                    int distance = 0;
                    for (RideEntity rideEntity : rideEntitiesPerClient) {
                        distance += rideEntity.getDistance();
                    }

                    ClientDisplay clientDisplay = new ClientDisplay();
                    clientDisplay.setClientId(c.getClientId());
                    clientDisplay.setName(c.getUserEntity().getFirstName() + " " + c.getUserEntity().getLastName());
                    clientDisplay.setPKB(c.getPKB());

                    try {
                        if (distance > c.getPKB()) {
                            priceToPay = (distance * 0.005);
                            warningPKB = true;

                            clientDisplay.setTotalMeters(distance);
                            clientDisplay.setPriceToPay(priceToPay);
                            clientDisplay.setWarningPKB(warningPKB);
                        }
                    } catch (Exception e) {
                        LOGGER.log(Level.WARNING, e.toString(), e);
                    }

                    if (clientCareInstitutionDAO.getCareInstitutionId(clientId).isActive()) {
                        returnList.add(clientDisplay);
                    }
                    return returnList;
                } catch (Exception e){
                    LOGGER.log(Level.WARNING, e.toString(), e);
                }
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return returnList;
    }

}
