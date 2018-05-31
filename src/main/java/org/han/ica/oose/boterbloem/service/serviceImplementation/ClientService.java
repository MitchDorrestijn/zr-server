package org.han.ica.oose.boterbloem.service.serviceImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.*;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation.*;
import org.han.ica.oose.boterbloem.dataAccess.entities.*;
import org.han.ica.oose.boterbloem.service.IClientservice;
import org.han.ica.oose.boterbloem.display.displayObject.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayObject.CreateClientDisplay;

import java.util.logging.*;

import org.han.ica.oose.boterbloem.display.displayObject.ClientDisplay;

import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientservice {
    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());

    private IClientDAO clientDAO = new ClientDAOImpl();
    private IUserDAO userDAO = new UserDAOImpl();
    private IClientUtilityDAO clientUtilityDAO = new ClientUtilityDAO();
    private IClientcareinstitutionDAO clientCareInstitutionDAO = new ClientcareinstitutionDAOImpl();
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();


    public ClientService() {
        //Empty constructor
    }

    public void createClient(CreateClientDisplay createClientDisplay) {
        try {
            userDAO.add(createClientDisplay.getClientEntity().getUserEntity());
            clientDAO.add(createClientDisplay.getClientEntity());
            ClientUtilityEntity clientUtilityEntity = new ClientUtilityEntity();
            clientUtilityEntity.setClientId(createClientDisplay.getClientEntity().getClientId());
            clientUtilityEntity.setUtility(createClientDisplay.getUtility());
            clientUtilityDAO.add(clientUtilityEntity);

            ClientcareinstitutionEntity clientcareinstitutionEntity = new ClientcareinstitutionEntity();
            clientcareinstitutionEntity.setClientId(createClientDisplay.getClientEntity().getClientId());
            clientcareinstitutionEntity.setCareInstitutionId(1);
            clientcareinstitutionEntity.setActive(true);
            clientCareInstitutionDAO.add(clientcareinstitutionEntity);

            for (String s : createClientDisplay.getLimitations()) {
                ClientLimitationEntity clientlimitationEntity = new ClientLimitationEntity();
                clientlimitationEntity.setClientId(createClientDisplay.getClientEntity().getClientId());
                clientlimitationEntity.setLimitation(s);
                clientlimitationDAO.add(clientlimitationEntity);
            }
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    /**
     * @return method returns a list of all found clients
     */
    public List <ClientDisplay> getAllClients() {
        List <ClientDisplay> clientDisplays = new ArrayList <>();
        try {
            List <ClientEntity> clientEntities = clientDAO.findAll();
            for (ClientEntity i : clientEntities) {
                try {
                    int driverId = i.getClientId();

                        double priceToPay;
                        boolean warningPKB;

                        List<RideEntity> rideEntitiesPerClient = rideDAO.getByClient(i.getClientId());

                        int distance = 0;
                        for(RideEntity rideEntity : rideEntitiesPerClient) {
                            distance += rideEntity.getDistance();
                        }

                        ClientDisplay clientDisplay = new ClientDisplay();
                        clientDisplay.setClientId(i.getClientId());
                        clientDisplay.setName(i.getUserEntity().getFirstName());
                        clientDisplay.setPKB(i.getPKB());
                        try{
                            if (distance > i.getPKB()) {
                                priceToPay = (distance * 0.005);
                                warningPKB = true;

                                clientDisplay.setTotalMeters(distance);
                                clientDisplay.setPriceToPay(priceToPay);
                                clientDisplay.setWarningPKB(warningPKB);
                            }
                        }catch(Exception e){
                            LOGGER.log(Level.SEVERE, e.toString(), e);
                        }

                    if (clientCareInstitutionDAO.getCareInstitutionId(driverId).isActive()) {
                        clientDisplays.add(clientDisplay);
                   }
                }catch(Exception e){
                    LOGGER.log(Level.WARNING, e.getMessage());
                }
            }
            return clientDisplays;
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return clientDisplays;
    }

    @Override
    public ClientEntity findById(int id) {
        try {
            return clientDAO.findById(id);
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    @Override
    public void updateClient(ClientDetailDisplay clientDetailDisplay) {
        int clientId = clientDetailDisplay.getClient().getClientId();
        if(clientDetailDisplay.getClient() != clientDAO.findById(clientId)){
            clientDAO.update(clientDetailDisplay.getClient());
        } if(clientDetailDisplay.getLimitations() != clientlimitationDAO.getByClientId(clientId)){
            clientlimitationDAO.updateClientLimitations(clientDetailDisplay.getLimitations(), clientId);
        }
    }

    @Override
    public ClientDetailDisplay getClientDetails(int id){
        ClientDetailDisplay clientDetailDisplay = new ClientDetailDisplay();
        try{
            clientDetailDisplay.setClient(clientDAO.findById(id));
            clientDetailDisplay.setLimitations(clientlimitationDAO.getByClientId(id));
        }catch(Exception e){
            LOGGER.log(Level.SEVERE,e.getMessage());
        }

        return clientDetailDisplay;
    }

    @Override
    public int getCareInstitutionById(int id) {
        return (clientCareInstitutionDAO.getCareInstitutionId(id).getCareInstitutionId());
    }

    @Override
    public void deleteClient(int id, int idcare) {
        try {
            ClientcareinstitutionEntityPK clientcareinstitutionEntityPK = new ClientcareinstitutionEntityPK();
            clientcareinstitutionEntityPK.setCareInstitutionId(idcare);
            clientcareinstitutionEntityPK.setClientId(id);
            ClientcareinstitutionEntity clientcareinstitutionEntity = clientCareInstitutionDAO.find(clientcareinstitutionEntityPK);
            clientcareinstitutionEntity.setActive(false);
            clientCareInstitutionDAO.update(clientcareinstitutionEntity);
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }
}
