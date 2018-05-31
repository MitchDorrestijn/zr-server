package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dataAccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.display.displayObject.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayObject.ClientDisplay;
import org.han.ica.oose.boterbloem.display.displayObject.CreateClientDisplay;

import java.util.List;

public interface IClientservice {
    /**
     * GET Client by Id
     * @param id of Client
     * @return Client
     */
    ClientEntity findById(int id);

    /**
     * GET all Clients
     * @return list of Clients
     */
    List <ClientDisplay> getAllClients();

    /**
     * GET Client-details by specific client
     * @param id of Client
     * @return Client-details
     */
    ClientDetailDisplay getClientDetails(int id);

    /**
     * CREATE new Client
     * @param client = new Client
     */
    void createClient(CreateClientDisplay client);

    /**
     * UPDATE Client
     * @param clientDetailDisplay = Client
     */
    void updateClient(ClientDetailDisplay clientDetailDisplay);

    /**
     * DELETE Client by Id
     * @param id of Client
     */
    void deleteClientById(int id, int idcare);

    /**
     * GET CareInstitution by Id
     * @param id of CareInstitution
     * @return CareInstitution
     */
    int getCareInstitutionById(int id);
}
