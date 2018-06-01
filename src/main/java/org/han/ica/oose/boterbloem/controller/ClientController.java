package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.display.displayobject.*;
import org.han.ica.oose.boterbloem.service.serviceimplementation.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {

    private IClientservice clientService = new ClientService();

    @Autowired
    public ClientController() {
        // Empty Constructor for Spring
    }

    /**
     * GET Client by Id
     * @param id of Client
     * @return Client
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientEntity getClientById(@PathVariable int id) {
        return clientService.findById(id);
    }

    /**
     * GET all Clients
     * @return list of Clients
     */
    @RequestMapping(value = "/clienten", method = RequestMethod.GET)
    public List <ClientDisplay> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * GET Client-details by specific client
     * @param id of Client
     * @return Client-details
     */
    @RequestMapping(value = "/getClient/{id}", method = RequestMethod.GET)
    public ClientDetailDisplay getClientDetails(@PathVariable int id) {
        return clientService.getClientDetails(id);
    }

    /**
     * POST new Client
     * @param createClientDisplay = new Client
     */
    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public void addClient(@RequestBody CreateClientDisplay createClientDisplay) {
        clientService.createClient(createClientDisplay);
    }

    /**
     * UPDATE Client
     * @param clientDetailDisplay = Client
     */
    @RequestMapping(value = "/update/client", method = RequestMethod.PUT)
    public void updateClient(@RequestBody ClientDetailDisplay clientDetailDisplay) {
        clientService.updateClient(clientDetailDisplay);
    }

    /**
     * DELETE Client by Id
     * @param id of Client
     */
    @RequestMapping(value = "/deleteclient/{id}", method = RequestMethod.DELETE)
    public void deleteClientById(@PathVariable int id) {
        clientService.deleteClientById(id, clientService.getCareInstitutionById(id));
    }

    /**
     * Get all the clients from a specific care institution
     * @return a list of information from the clients of a specifice care institution
     */
    @RequestMapping(value = "/clienten/zorginstelling/{id}", method = RequestMethod.GET)
    public List<ClientDisplay> getAllClientsFromASpecificCareInstitution(@PathVariable int id) {
        return clientService.getAllClientsFromASpecificCareInstitution(id);
    }
}