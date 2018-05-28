package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.service.ClientService;
import org.han.ica.oose.boterbloem.service.projection.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService = new ClientService();

    /** Constructs a new ClientController. */
    @Autowired
    public ClientController() {
        //empty constructor for spring
    }
    /**
     * @param createClientDisplay createClientDisplay to be added
     * @return new createClientDisplay
     */
    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public void addClient(@RequestBody CreateClientDisplay createClientDisplay) {
        clientService.createClient(createClientDisplay);
    }

    /**
     * Method for returning clients
     *
     * @return A arraylist of clients
     */
    @CrossOrigin
    @RequestMapping(value = "/clienten", method = RequestMethod.GET)
    public List<ClientDisplay> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * @param id of Client
     * @return details of a Client
     */
    @RequestMapping(value = "/getClient/{id}", method = RequestMethod.GET)
    public ClientDetailDisplay getClientDetails (@PathVariable int id) {
        return clientService.getClientDetails(id);
    }

    /**
     * Method for returning a client
     *
     * @param id of Client
     * @return Client
     */
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientEntity getClientById(@PathVariable int id) {
        return clientService.findById(id);
    }

    /**
     * @param clientDetailDisplay clientDetailDisplay
     */
    @CrossOrigin
    @RequestMapping(value = "/update/client", method = RequestMethod.PUT)
    public void updateDriverDetails(@RequestBody ClientDetailDisplay clientDetailDisplay) {
        clientService.updateClient(clientDetailDisplay);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteclient/{id}", method = RequestMethod.DELETE)
    public ResponseEntity <ClientEntity> deleteClient(@PathVariable int id) {
        clientService.deleteClient(id, clientService.getCareInstitutionById(id));
        return new ResponseEntity <>(HttpStatus.NO_CONTENT);
    }
}
