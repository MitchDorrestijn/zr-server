package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.Client;
import org.han.ica.oose.boterbloem.service.serviceimplementation.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class ClientControllerTest extends JpaTestConfig {

    private Client clientA = new Client();
    private Client clientB = new Client();
    private Client clientC = new Client();

    ClientEntity clientEntity = new ClientEntity();

    private ClientDisplay clientDisplayA = new ClientDisplay();
    private ClientDisplay clientDisplayB = new ClientDisplay();

    ClientDetailDisplay clientDetailDisplayA = new ClientDetailDisplay();

    private List<Client> clients = new ArrayList<>();
    private List<ClientDisplay> clientDisplays = new ArrayList<>();

    private ClientController clientController = new ClientController();
    private ClientService clientService = mock(ClientService.class);

    @Before
    public void setup() {
        Address address = new Address();

        address.setHouseNumber("5");
        address.setResidence("somewhere");
        address.setStreet("SomeString");
        address.setZipCode("SomeString");

        clientA.setFirstName("Henk");
        clientA.setLastName("lastname");
        clientA.setAddress(address);

        clientB.setFirstName("Klaas");
        clientB.setLastName("lastname");
        clientB.setAddress(address);

        clientC.setFirstName("Kees");
        clientC.setLastName("lastname");
        clientC.setAddress(address);

        clientDisplayA.setName("Slagathor");
        clientDisplayA.setClientId(1);

        clientDisplayB.setName("Snorfiets");
        clientDisplayB.setClientId(2);

        clientEntity.setClientId(1);

        clientDetailDisplayA.setClient(clientEntity);


        clients.add(clientA);
        clients.add(clientB);
        clients.add(clientC);
        clientDisplays.add(clientDisplayA);
        clientDisplays.add(clientDisplayB);

        clientController.clientService = clientService;
    }

    @Test
    public void getAllClients() {
        when(clientService.getAllClients()).thenReturn(clientDisplays);
        List<ClientDisplay> testClients = clientController.getAllClients();
        assertEquals(2, testClients.size());
    }

    @Test
    public void getClientById() {
        when(clientService.findById(1)).thenReturn(clientEntity);
        ClientEntity testClient = clientController.getClientById(1);
        assertEquals(1, testClient.getClientId());
    }

    @Test
    public void getClientDetails() {
        when(clientService.getClientDetails(1)).thenReturn(clientDetailDisplayA);
        ClientDetailDisplay clientDetailDisplay = clientController.getClientDetails(1);
        assertEquals(clientDetailDisplayA.getClient().getClientId(), clientDetailDisplay.getClient().getClientId());
    }

}
