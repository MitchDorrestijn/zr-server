package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;
import java.util.List;

public interface IClientDAO {

    /**
     * Adds a new Client to the database
     * @param client Client object which contains the data that will be added
     */
    void create(Client client);

    /**
     * Requests a list of all current Clients from the database
     *
     * @return The list of Clients
     */
    List<Client> getAllClients();

    /**
     * Reusts a specific Client from the database
     * @param id the id of the client
     * @return a specific client with the given id
     */
    Client getClientById(int id);
}
