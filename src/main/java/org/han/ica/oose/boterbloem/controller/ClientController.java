package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.ClientDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.CreateClientDisplay;
import org.han.ica.oose.boterbloem.security.AdminAndCareInstitutionAuthorization;
import org.han.ica.oose.boterbloem.security.AdminAuthorization;
import org.han.ica.oose.boterbloem.service.IClientservice;
import org.han.ica.oose.boterbloem.service.serviceimplementation.ClientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/client")
public class ClientController {

    protected IClientservice clientService = new ClientService();

    @Autowired
    public ClientController() {
        // Empty Constructor for Spring
    }

    /**
     * GET Client by Id
     *
     * @param id of Client
     * @return Client
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientEntity getClientById(@PathVariable int id) {
        return clientService.findById(id);
    }

    /**
     * GET all Clients
     *
     * @return list of Clients
     */
    @AdminAuthorization
    @RequestMapping(value = "/clienten", method = RequestMethod.GET)
    public List<ClientDisplay> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * GET Client-details by specific client
     *
     * @param id of Client
     * @return Client-details
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/getClient/{id}", method = RequestMethod.GET)
    public ClientDetailDisplay getClientDetails(@PathVariable int id) {
        return clientService.getClientDetails(id);
    }

    /**
     * POST new Client
     *
     * @param createClientDisplay = new Client
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public void addClient(@RequestBody CreateClientDisplay createClientDisplay) {
        System.out.println(createClientDisplay.getClient());
        clientService.createClient(createClientDisplay);
    }

    /**
     * UPDATE Client
     *
     * @param clientDetailDisplay = Client
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/update/client", method = RequestMethod.PUT)
    public void updateClient(@RequestBody ClientDetailDisplay clientDetailDisplay) {
        clientService.updateClient(clientDetailDisplay);
    }

    /**
     * DELETE Client by Id
     *
     * @param id of Client
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/deleteclient/{id}", method = RequestMethod.DELETE)
    public void deleteClientById(@PathVariable int id) {
        clientService.deleteClientById(id, clientService.getCareInstitutionById(id));
    }

    /**
     * Get all the clients from a specific care institution
     *
     * @return a list of information from the clients of a specifice care institution
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/clienten/zorginstelling/{id}", method = RequestMethod.GET)
    public List<ClientDisplay> getAllClientsFromASpecificCareInstitution(@PathVariable int id) {
        return clientService.getAllClientsFromASpecificCareInstitution(id);
    }
}