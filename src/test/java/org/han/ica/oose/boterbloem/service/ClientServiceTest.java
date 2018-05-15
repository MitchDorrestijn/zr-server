package org.han.ica.oose.boterbloem.service;
import org.han.ica.oose.boterbloem.dao.ClientDAO;
import org.han.ica.oose.boterbloem.domain.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClientServiceTest {



    private Client clientA = new Client("Mees",500,false,0,500);
    private Client clientB = new Client("Mees",500,false,0,500);
    private Client clientC = new Client("Mees",500,false,0,500);
    private Client clientD = new Client("Mees",500,false,0,500);


    private List<Client> clients = new ArrayList<>();

    private ClientService clientService = new ClientService();
    private ClientDAO clientDAO = mock(ClientDAO.class);


    @Before
    public void setup() throws SQLException {
        clients.add(clientA);
        clients.add(clientB);
        clients.add(clientC);
        clients.add(clientD);

        clientService.clientDAO = clientDAO;
    }

    @Test
    public void getAllClients() throws SQLException {
        when(clientDAO.getAllCliënts()).thenReturn(clients);
        List<Client> testClients = clientService.getAllCliënts();
        assertEquals(4, testClients.size());
    }

    @Test
    public void findByIdTest() throws SQLException {
        when(clientDAO.getCliëntById(1)).thenReturn(clientA);
        Client client = clientService.findById(1);

        assertEquals(clientA.getName(), client.getName());

    }
}
