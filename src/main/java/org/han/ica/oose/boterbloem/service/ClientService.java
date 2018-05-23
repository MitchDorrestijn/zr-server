package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.ClientDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IClientDAO;
import org.han.ica.oose.boterbloem.entity.ClientEntity;

import javax.persistence.*;
import java.util.*;
import java.util.logging.*;

public class ClientService implements IClientservice {

    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private IClientDAO clientDAO = new ClientDAOImpl(entityManager);

    public ClientService() {
        //Empty constructor
    }

    @Override
    public ClientEntity findById(int id) {
        return clientDAO.findById(id);
    }

    @Override
    public List <ClientEntity> getAllClients() {
        return clientDAO.findAll();
    }

    @Override
    public void createClient(ClientEntity client) {
        clientDAO.add(client);
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
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    @Override
    public void deleteClient(int id) {
        clientDAO.removeById(id);
    }
}