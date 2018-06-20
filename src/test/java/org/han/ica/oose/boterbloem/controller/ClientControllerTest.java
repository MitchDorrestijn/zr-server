package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UserEntity;
import org.han.ica.oose.boterbloem.display.displaymapper.ClientDisplayMapper;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.CreateClientDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.ClientMapper;
import org.han.ica.oose.boterbloem.domain.domainmappers.LimitationMapper;
import org.han.ica.oose.boterbloem.service.IClientservice;
import org.han.ica.oose.boterbloem.service.serviceimplementation.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class ClientControllerTest extends JpaTestConfig {
    ClientController clientController = new ClientController();
    IClientservice clientservice = new ClientService();
    ClientMapper clientMapper = new ClientMapper();
    IClientDAO clientDAO = new ClientDAOImpl();
    IRideDAO rideDAO = new RideDAOImpl();

    IUserDAO userDAO = new UserDAOImpl();
    IClientUtilityDAO clientUtilityDAO = new ClientUtilityDAO();
    IClientcareinstitutionDAO clientCareInstitutionDAO = new ClientcareinstitutionDAOImpl();
    IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    ClientDisplayMapper clientDisplayMapper = new ClientDisplayMapper();

    LimitationMapper limitationMapper = new LimitationMapper();

    @Before
    public void setup() {
        clientDAO.setEntityManager(em);
        userDAO.setEntityManager(em);
        clientUtilityDAO.setEntityManager(em);
        clientCareInstitutionDAO.setEntityManager(em);
        clientlimitationDAO.setEntityManager(em);
        rideDAO.setEntityManager(em);

        clientMapper.setClientDAO(clientDAO);
        clientMapper.setClientlimitationDAO(clientlimitationDAO);
        clientMapper.setLimitationMapper(limitationMapper);
        clientDisplayMapper.setClientDAO(clientDAO);
        clientDisplayMapper.setRideDAO(rideDAO);

        clientservice.setClientMapper(clientMapper);
        clientservice.setClientDAO(clientDAO);
        clientservice.setClientlimitationDAO(clientlimitationDAO);
        clientservice.setUserDAO(userDAO);
        clientservice.setClientCareInstitutionDAO(clientCareInstitutionDAO);
        clientservice.setClientDisplayMapper(clientDisplayMapper);
        clientservice.setClientUtilityDAO(clientUtilityDAO);

        clientController.setClientService(clientservice);
    }

    @Test
    public void testGetClientById() {
        ClientEntity getClientById = clientController.getClientById(2);
        assertEquals(2, getClientById.getClientId());
        assertEquals(500, getClientById.getPKB());
        assertEquals(0, getClientById.getCompanionRequired());
        assertEquals("Sven", getClientById.getCompanion());
        assertEquals(0, getClientById.getDriverPreferenceForced());
        assertEquals("NL63RABE3559999235", getClientById.getBankAccount());
        assertEquals(null, getClientById.getImage());
        assertEquals("Robin", getClientById.getUserEntity().getFirstName());
        assertEquals("Schuiling", getClientById.getUserEntity().getLastName());
        assertEquals("Robin@hotmail.com", getClientById.getUserEntity().getEmail());
        assertEquals(0, getClientById.getUserEntity().getFirstTimeProfileCheck());
        assertEquals("33", getClientById.getUserEntity().getHouseNumber());
        assertEquals("test", getClientById.getUserEntity().getPassword());
        assertEquals("0687654321", getClientById.getUserEntity().getPhoneNumber());
        assertEquals("Arnhem", getClientById.getUserEntity().getResidence());
        assertEquals("Dorpstraat", getClientById.getUserEntity().getStreet());
        assertEquals("1234EF", getClientById.getUserEntity().getZipCode());
        assertEquals(2, getClientById.getUserEntity().getId());
        assertEquals("fgh", getClientById.getUserEntity().getPasswordSalt());
    }

    @Test
    public void testGetAllClients(){
        List<ClientDisplay> clientDisplayList = clientController.getAllClients();
        assertEquals(5, clientDisplayList.size());
    }

    @Test
    public void testGetClientDetails(){
        ClientDetailDisplay clientDetailDisplay = clientController.getClientDetails(3);
        assertEquals(null, clientDetailDisplay.getClient().getImage());
        assertEquals("NL63RABE3559999235", clientDetailDisplay.getClient().getBankAccount());
        assertEquals(0, clientDetailDisplay.getClient().getUserEntity().getFirstTimeProfileCheck());
        assertEquals(3, clientDetailDisplay.getClient().getUserEntity().getId());
        assertEquals("Frits", clientDetailDisplay.getClient().getUserEntity().getFirstName());
        assertEquals("van Keulen", clientDetailDisplay.getClient().getUserEntity().getLastName());
        assertEquals("koen@yahoo.com", clientDetailDisplay.getClient().getUserEntity().getEmail());
        assertEquals("12", clientDetailDisplay.getClient().getUserEntity().getHouseNumber());
        assertEquals("pass", clientDetailDisplay.getClient().getUserEntity().getPassword());
        assertEquals("0678945612", clientDetailDisplay.getClient().getUserEntity().getPhoneNumber());
        assertEquals("Wageningen", clientDetailDisplay.getClient().getUserEntity().getResidence());
        assertEquals("Dorplaan", clientDetailDisplay.getClient().getUserEntity().getStreet());
        assertEquals("5673TR", clientDetailDisplay.getClient().getUserEntity().getZipCode());
        assertEquals("wer", clientDetailDisplay.getClient().getUserEntity().getPasswordSalt());
        assertEquals(0, clientDetailDisplay.getClient().getDriverPreferenceForced());
        assertEquals("Henk", clientDetailDisplay.getClient().getCompanion());
        assertEquals(0, clientDetailDisplay.getClient().getCompanionRequired());
        assertEquals(500, clientDetailDisplay.getClient().getPKB());
        assertEquals(3, clientDetailDisplay.getClient().getClientId());
        assertEquals(1, clientDetailDisplay.getLimitations().size());
    }

    @Test
    public void testAddClient() throws ParseException {
        CreateClientDisplay createClientDisplay = new CreateClientDisplay();
        ClientEntity clientEntity = new ClientEntity();
        UserEntity userEntity = new UserEntity();
        List<String> limitations = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse("20110210");
        java.sql.Date sql = new java.sql.Date(parsed.getTime());

        limitations.add("ouderen");

        createClientDisplay.setCareId(1);
        createClientDisplay.setCompanionForced(true);
        createClientDisplay.setLimitations(limitations);
        createClientDisplay.setUtility("scootmobiel");

        clientEntity.setBankAccount("NLRABO046524314");
        clientEntity.setCompanion("Sven");
        clientEntity.setCompanionRequired(Byte.parseByte("1"));
        clientEntity.setImage("image");
        clientEntity.setPKB(45);
        clientEntity.setWarningPKB(false);
        clientEntity.setDriverPreferenceForced(Byte.parseByte("1"));

        userEntity.setFirstName("Micro");
        userEntity.setEmail("micro@example.com");
        userEntity.setLastName("van Halen");
        userEntity.setDateOfBirth(sql);
        userEntity.setFirstTimeProfileCheck(Byte.parseByte("1"));
        userEntity.setHouseNumber("44");
        userEntity.setPassword("Qwerty");
        userEntity.setResidence("Zwolle");
        userEntity.setStreet("Meerlaan");
        userEntity.setZipCode("9476TT");
        userEntity.setPhoneNumber("0683765241");

        clientEntity.setUserEntity(userEntity);
        createClientDisplay.setClient(clientEntity);

        clientController.addClient(createClientDisplay);

        int latestId = clientDAO.latestId();

        assertEquals("Micro", em.find(ClientEntity.class, latestId).getUserEntity().getFirstName());
    }

    @Test
    public void testUpdateClient(){
        ClientDetailDisplay clientDetailDisplay = clientController.getClientDetails(3); //Koen
        clientDetailDisplay.getClient().getUserEntity().setFirstName("Frits");

        clientController.updateClient(clientDetailDisplay);

        String result = clientController.getClientById(3).getUserEntity().getFirstName();
        String expected = "Frits";
        assertEquals(expected, result);
    }

    @Test
    public void testDeleteClientById(){
        clientController.deleteClientById(2);
        List<ClientDisplay> clientDisplayList = clientController.getAllClients();
        assertEquals(5, clientDisplayList.size());
    }

    @Test
    public void testGetAllClientsFromASpecificCareInstitution(){
        List<ClientDisplay> clientDisplayList = clientController.getAllClientsFromASpecificCareInstitution(1);
        assertEquals(1, clientDisplayList.size());
    }
}