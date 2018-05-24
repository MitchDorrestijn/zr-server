package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.*;
import org.han.ica.oose.boterbloem.service.projection.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.service.projection.CreateClientDisplay;

import java.util.*;
import java.util.logging.*;

import org.han.ica.oose.boterbloem.daoHibernate.ClientDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IClientDAO;
import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.service.projection.ClientDisplay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientservice {

    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private IClientDAO clientDAO = new ClientDAOImpl(entityManager);
    private IRideDAO rideDAO = new RideDAOImpl(entityManager);
    private IUserDAO userDAO = new UserDAOImpl(entityManager);
    private IClientUtilityDAO clientUtilityDAO = new ClientUtilityDAO(entityManager);
    private IClientcareinstitutionDAO clientCareInstitutionDAO = new ClientcareinstitutionDAOImpl(entityManager);
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl(entityManager);


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


            for (String s : createClientDisplay.getLimitations()) {
                ClientLimitationEntity clientlimitationEntity = new ClientLimitationEntity();
                clientlimitationEntity.setClientId(createClientDisplay.getClientEntity().getClientId());
                clientlimitationEntity.setLimitation(s);
                clientlimitationDAO.add(clientlimitationEntity);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    /**
     * @return method returns a list of all found clients
     */
    public List<ClientDisplay> getAllClients() {
        List<ClientDisplay> clientDisplays = new ArrayList<>();
        try{
            List<ClientEntity> clientEntities = clientDAO.findAll();
            for (ClientEntity i : clientEntities) {
                int driverId = i.getClientId();
                if (clientCareInstitutionDAO.getCareInstitutionId(driverId).isActive()) {
                    double priceToPay = 0;
                    boolean warningPKB = false;
                    ClientDisplay clientDisplay = new ClientDisplay();
                    clientDisplay.setClientId(i.getClientId());
                    clientDisplay.setName(i.getUserEntity().getFirstName());
                    clientDisplay.setPKB(i.getPKB());
                    int distance = (i.getRideEntity().getDistance());
                    if (distance > i.getPKB()) {
                        priceToPay = (i.getRideEntity().getDistance() * 0.005);
                        warningPKB = true;
                    }
                    clientDisplay.setTotalMeters(i.getRideEntity().getDistance());
                    clientDisplay.setPriceToPay(priceToPay);
                    clientDisplay.setWarningPKB(warningPKB);
                    clientDisplays.add(clientDisplay);
                }
            }
            return clientDisplays;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return clientDisplays;
    }

    @Override
    public ClientEntity findById(int id) {
        try {
            return clientDAO.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    @Override
    public ClientDetailDisplay getClientDetails(int id) {
        ClientDetailDisplay detailDisplay = new ClientDetailDisplay();

        try {
            ClientEntity client = clientDAO.findById(id);

            detailDisplay.setId(client.getClientId());
            detailDisplay.setImage(client.getImage());
            detailDisplay.setFirstName(client.getUserEntity().getFirstName());
            detailDisplay.setLastName(client.getUserEntity().getLastName());
            detailDisplay.setDateOfBirth(client.getUserEntity().getDateOfBirth());
            detailDisplay.setStreet(client.getUserEntity().getStreet());
            detailDisplay.setHouseNumber(client.getUserEntity().getHouseNumber());
            detailDisplay.setZipCode(client.getUserEntity().getZipCode());
            detailDisplay.setResidence(client.getUserEntity().getResidence());
            detailDisplay.setEmail(client.getUserEntity().getEmail());
            detailDisplay.setPhoneNumber(client.getUserEntity().getPhoneNumber());
            detailDisplay.setBankAccount(client.getBankAccount());
            detailDisplay.setPassword(client.getUserEntity().getPassword());
            detailDisplay.setCompanionRequired(client.getCompanionRequired());
            detailDisplay.setClientlimitationEntityList(clientlimitationDAO.getAllLimitationById(id));
            detailDisplay.setPersonalKmBudget(client.getPKB());
            detailDisplay.setTotalRides(rideDAO.totalRideClient(id));

            return detailDisplay;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return detailDisplay;
    }

    @Override
    public void updateClient(ClientEntity newClient) {
        try {
            ClientEntity currentClient;

            currentClient = clientDAO.findById(newClient.getClientId());

            currentClient.getUserEntity().setFirstName(newClient.getUserEntity().getFirstName());
            currentClient.getUserEntity().setLastName(newClient.getUserEntity().getLastName());
            currentClient.getUserEntity().setEmail(newClient.getUserEntity().getEmail());
            currentClient.getUserEntity().setPhoneNumber(newClient.getUserEntity().getPhoneNumber());
            currentClient.getUserEntity().setStreet(newClient.getUserEntity().getStreet());
            currentClient.getUserEntity().setHouseNumber(newClient.getUserEntity().getHouseNumber());

            currentClient.getUserEntity().setZipCode(newClient.getUserEntity().getZipCode());
            currentClient.getUserEntity().setResidence(newClient.getUserEntity().getResidence());
            currentClient.getUserEntity().setPassword(newClient.getUserEntity().getPassword());
            currentClient.getUserEntity().setPasswordSalt(newClient.getUserEntity().getPasswordSalt());
            currentClient.getUserEntity().setDateOfBirth(newClient.getUserEntity().getDateOfBirth());
            currentClient.getUserEntity().setFirstTimeProfileCheck(newClient.getUserEntity().getFirstTimeProfileCheck());

            clientDAO.update(newClient);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
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
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }
}
