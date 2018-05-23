package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.entity.ClientEntity;

import java.util.List;

public interface IClientservice {

    /**
     * @param id the clientId thats used for the query
     * @return A specific client with the given id
     */
    ClientEntity findById(int id);

    /**
     * @return method returns a list of all found clients
     */
    List <ClientEntity> getAllClients();

    /**
     * @param client that's going to be added to the database
     */
    void createClient(ClientEntity client);

    /**
     * @param client Client that needs a update
     */
    void updateClient(ClientEntity client);

    /**
     * @param id delete a Client
     */
    void deleteClient(int id);

}
