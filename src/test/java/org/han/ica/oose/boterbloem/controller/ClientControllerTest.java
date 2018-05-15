package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.Client;
import org.han.ica.oose.boterbloem.service.ClientService;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClientControllerTest {

    private Client clientA = new Client("Mees",500,false,0,500);
    private Client clientB = new Client("Mitch",850,true,0,1000);
    private Client clientC = new Client("Martijn",320,true,0,500);
    private Client clientD = new Client("Mees",500,false,0,500);

    private List<Client> clients = new ArrayList<>();

    private ClientController clientController = new ClientController();
    private ClientService clientService = mock(ClientService.class);

    @Before
    public void setup() {
        clients.add(clientA);
        clients.add(clientB);
        clients.add(clientC);
        clients.add(clientD);
        clientController.clientService = clientService;
    }

    @Test
    public void getAllClients() throws SQLException {
        when(clientService.getAllClients()).thenReturn(clients);
        List<Client> testClients = clientController.getAllCliënten();
        assertEquals(4, testClients.size());
    }

    @Test
    public void getCareInstitutionTest() throws SQLException {
        when(clientService.findById(1)).thenReturn(clientA);
        Client testClient = clientController.getCliëntById("1");
        assertEquals("Mees", testClient.getName());
    }

}
