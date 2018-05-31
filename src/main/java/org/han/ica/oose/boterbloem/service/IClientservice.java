package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dataAccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.display.displayObject.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayObject.ClientDisplay;
import org.han.ica.oose.boterbloem.display.displayObject.CreateClientDisplay;

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
    List <ClientDisplay> getAllClients();

    /**
     * @param id of Client
     * @return details of a Client
     */
    ClientDetailDisplay getClientDetails(int id);
    /**
     * @param client that's going to be added to the database
     */
    void createClient(CreateClientDisplay client);

    /**
     * @param clientDetailDisplay Client that needs a update
     */
    void updateClient(ClientDetailDisplay clientDetailDisplay);

    /**
     * @param id delete a Client
     */
    void deleteClient(int id, int idcare);

    int getCareInstitutionById(int id);
}
