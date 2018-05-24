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
    }

    /**
     * @return method returns a list of all found clients
     */
    public List<ClientDisplay> getAllClients() {
        List<ClientDisplay> clientDisplays = new ArrayList<>();

        List<ClientEntity> clientEntities = clientDAO.findAll();
        for (ClientEntity i : clientEntities) {
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
        return clientDisplays;
    }

    @Override
    public ClientEntity findById(int id) {
        return clientDAO.findById(id);
    }

    @Override
    public ClientDetailDisplay getClientDetails(int id) {
        ClientEntity client = clientDAO.findById(id);
        List<String> clientLimitations = clientlimitationDAO.getAllLimitationById(id);

        int clientId = client.getClientId();
        String image = client.getImage();
        String firstName = client.getUserEntity().getFirstName();
        String lastName = client.getUserEntity().getLastName();
        Date dateofBirth = client.getUserEntity().getDateOfBirth();
        String street = client.getUserEntity().getStreet();
        String houseNumber = client.getUserEntity().getHouseNumber();
        String zipCode = client.getUserEntity().getZipCode();

        String residence = client.getUserEntity().getResidence();
        String email = client.getUserEntity().getEmail();
        String phoneNumber = client.getUserEntity().getPhoneNumber();
        String bankAccount = client.getBankAccount();
        String password = client.getUserEntity().getPassword();
        byte companionRequired = client.getCompanionRequired();
        int personalKmBudget = client.getPKB();
        int totalRide = rideDAO.totalRideClient(id);


        ClientDetailDisplay detailDisplay = new ClientDetailDisplay();

        detailDisplay.setId(clientId);
        detailDisplay.setImage(image);
        detailDisplay.setFirstName(firstName);
        detailDisplay.setLastName(lastName);
        detailDisplay.setDateOfBirth(dateofBirth);
        detailDisplay.setStreet(street);
        detailDisplay.setHouseNumber(houseNumber);
        detailDisplay.setZipCode(zipCode);

        detailDisplay.setResidence(residence);
        detailDisplay.setEmail(email);
        detailDisplay.setPhoneNumber(phoneNumber);
        detailDisplay.setBankAccount(bankAccount);
        detailDisplay.setPassword(password);
        detailDisplay.setCompanionRequired(companionRequired);
        detailDisplay.setClientlimitationEntityList(clientLimitations);
        detailDisplay.setPersonalKmBudget(personalKmBudget);
        detailDisplay.setTotalRides(totalRide);

        return detailDisplay;
    }

    @Override
    public void updateClient(ClientEntity client) {
        String firstName = client.getUserEntity().getFirstName();
        String lastName = client.getUserEntity().getLastName();
        String email = client.getUserEntity().getEmail();
        String phoneNumber = client.getUserEntity().getPhoneNumber();
        String street = client.getUserEntity().getStreet();
        String houseNumber = client.getUserEntity().getHouseNumber();

        String zipCode = client.getUserEntity().getZipCode();
        String residence = client.getUserEntity().getResidence();
        String password = client.getUserEntity().getPassword();
        String passwordSalt = client.getUserEntity().getPasswordSalt();
        Date dateOfBirth = client.getUserEntity().getDateOfBirth();
        byte firstTimeProfileCheck = client.getUserEntity().getFirstTimeProfileCheck();

        try {
            ClientEntity currentClient;

            currentClient = clientDAO.findById(client.getClientId());

            currentClient.getUserEntity().setFirstName(firstName);
            currentClient.getUserEntity().setLastName(lastName);
            currentClient.getUserEntity().setEmail(email);
            currentClient.getUserEntity().setPhoneNumber(phoneNumber);
            currentClient.getUserEntity().setStreet(street);
            currentClient.getUserEntity().setHouseNumber(houseNumber);

            currentClient.getUserEntity().setZipCode(zipCode);
            currentClient.getUserEntity().setResidence(residence);
            currentClient.getUserEntity().setPassword(password);
            currentClient.getUserEntity().setPasswordSalt(passwordSalt);
            currentClient.getUserEntity().setDateOfBirth((java.sql.Date) dateOfBirth);
            currentClient.getUserEntity().setFirstTimeProfileCheck(firstTimeProfileCheck);

            clientDAO.update(client);
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
        ClientcareinstitutionEntityPK clientcareinstitutionEntityPK = new ClientcareinstitutionEntityPK();
        clientcareinstitutionEntityPK.setCareInstitutionId(idcare);
        clientcareinstitutionEntityPK.setClientId(id);
        ClientcareinstitutionEntity clientcareinstitutionEntity = clientCareInstitutionDAO.find(clientcareinstitutionEntityPK);
        clientcareinstitutionEntity.setActive(false);
        clientCareInstitutionDAO.update(clientcareinstitutionEntity);
    }
}
