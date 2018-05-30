package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.*;
import org.han.ica.oose.boterbloem.mapper.ClientMapper;
import org.han.ica.oose.boterbloem.service.displays.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.service.displays.CreateClientDisplay;

import java.util.logging.*;

import org.han.ica.oose.boterbloem.daoHibernate.ClientDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IClientDAO;
import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.service.displays.ClientDisplay;

import java.util.List;

public class ClientService implements IClientservice {
    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());

    private IClientDAO clientDAO = new ClientDAOImpl();
    private IUserDAO userDAO = new UserDAOImpl();
    private IClientUtilityDAO clientUtilityDAO = new ClientUtilityDAO();
    private IClientcareinstitutionDAO clientCareInstitutionDAO = new ClientcareinstitutionDAOImpl();
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();
    private ClientMapper clientMapper = new ClientMapper();


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

    /**
     * Get all the clients from a specific care institution
     * @return a list of information from the clients of a specific care institution
     */
    public List<ClientDisplay> getAllClientsFromASpecificCareInstitution(int id){
        return clientMapper.getAllClientsFromASpecificCareInstitution(id);
    }

    /**
     * Gets all the clients from all care institutions
     * @return method returns a list of all found clients
     */
    public List <ClientDisplay> getAllClients() {
        return clientMapper.getAllClients();
    }

}
