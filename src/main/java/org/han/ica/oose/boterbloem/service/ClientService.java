package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.ClientDAO;
import org.han.ica.oose.boterbloem.domain.Client;

public class ClientService {

    ClientDAO clientDAO = new ClientDAO();

    public ClientService() {
        //Empty constructor
    }

    public void createClient(Client client) {
        clientDAO.create(client);
    }

}
