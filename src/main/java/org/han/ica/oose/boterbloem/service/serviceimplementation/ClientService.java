package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.display.displaymapper.ClientDisplayMapper;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.CreateClientDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.User;
import org.han.ica.oose.boterbloem.service.IClientservice;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;


public class ClientService implements IClientservice {
    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());

    private IClientDAO clientDAO = new ClientDAOImpl();
    private IUserDAO userDAO = new UserDAOImpl();
    private IClientUtilityDAO clientUtilityDAO = new ClientUtilityDAO();
    private IClientcareinstitutionDAO clientCareInstitutionDAO = new ClientcareinstitutionDAOImpl();
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    private ClientDisplayMapper clientDisplayMapper = new ClientDisplayMapper();

    public ClientService() {
        //Empty constructor
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientEntity findById(int id) {
        try {
            return clientDAO.findById(id);
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ClientDisplay> getAllClients() {
        return clientDisplayMapper.getAllClients();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientDetailDisplay getClientDetails(int id) {
        ClientDetailDisplay clientDetailDisplay = new ClientDetailDisplay();
        try {
            clientDetailDisplay.setClient(clientDAO.findById(id));
            clientDetailDisplay.setLimitations(clientlimitationDAO.getByClientId(id));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return clientDetailDisplay;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createClient(CreateClientDisplay createClientDisplay) {
        try {
            userDAO.add(createClientDisplay.getClient().getUserEntity());
            clientDAO.add(createClientDisplay.getClient());
            ClientUtilityEntity clientUtilityEntity = new ClientUtilityEntity();
            clientUtilityEntity.setClientId(createClientDisplay.getClient().getClientId());
            clientUtilityEntity.setUtility(createClientDisplay.getUtility());
            clientUtilityDAO.add(clientUtilityEntity);

            ClientcareinstitutionEntity clientcareinstitutionEntity = new ClientcareinstitutionEntity();
            clientcareinstitutionEntity.setClientId(createClientDisplay.getClient().getClientId());
            clientcareinstitutionEntity.setCareInstitutionId(createClientDisplay.getCareId());
            clientcareinstitutionEntity.setActive(true);
            clientCareInstitutionDAO.add(clientcareinstitutionEntity);

            for (String s : createClientDisplay.getLimitations()) {
                ClientLimitationEntity clientlimitationEntity = new ClientLimitationEntity();
                clientlimitationEntity.setClientId(createClientDisplay.getClient().getClientId());
                clientlimitationEntity.setLimitation(s);
                clientlimitationDAO.add(clientlimitationEntity);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateClient(ClientDetailDisplay clientDetailDisplay) {
        int clientId = clientDetailDisplay.getClient().getClientId();
        if (!clientDetailDisplay.getClient().equals(clientDAO.findById(clientId)) || !clientDetailDisplay.getClient().getUserEntity().equals(userDAO.findById(clientId))) {
            clientDAO.update(clientDetailDisplay.getClient());
            userDAO.update(clientDetailDisplay.getClient().getUserEntity());
        }
        if (!clientDetailDisplay.getLimitations().equals(clientlimitationDAO.getByClientId(clientId))) {
            clientlimitationDAO.updateClientLimitations(clientDetailDisplay.getLimitations(), clientId);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteClientById(int id, int idcare) {
        try {
            ClientcareinstitutionEntityPK clientcareinstitutionEntityPK = new ClientcareinstitutionEntityPK();
            clientcareinstitutionEntityPK.setCareInstitutionId(idcare);
            clientcareinstitutionEntityPK.setClientId(id);
            ClientcareinstitutionEntity clientcareinstitutionEntity = clientCareInstitutionDAO.find(clientcareinstitutionEntityPK);
            clientcareinstitutionEntity.setActive(false);
            clientCareInstitutionDAO.update(clientcareinstitutionEntity);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCareInstitutionById(int id) {
        return (clientCareInstitutionDAO.getCareInstitutionId(id).getCareInstitutionId());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ClientDisplay> getAllClientsFromASpecificCareInstitution(int id) {
        return clientDisplayMapper.getAllClientsFromASpecificCareInstitution(id);
    }

}
