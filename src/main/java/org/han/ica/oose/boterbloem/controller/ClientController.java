package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.service.ClientService;
import org.han.ica.oose.boterbloem.service.projection.CreateClientDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {
    protected static final Logger LOGGER = Logger.getLogger(CareInstitutionController.class.getName());

    protected ClientService clientService = new ClientService();

    /**
     * @param createClientDisplay createClientDisplay to be added
     * @return new createClientDisplay
     */
    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public void addClient(@RequestBody CreateClientDisplay createClientDisplay) {
        clientService.createClient(createClientDisplay);
    }

    @Autowired
    ClientController() {
        //empty constructor for spring
    }

    /**
     * Method for returning clients
     *
     * @return A arraylist of clients
     */
    @CrossOrigin
    @RequestMapping(value = "/clienten", method = RequestMethod.GET)
    public List<ClientEntity> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * Method for returning a client
     *
     * @param id of Client
     * @return Client
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientEntity getClientById(@PathVariable int id) {
        return clientService.findById(id);
    }

    /**
     * @param client Client
     * @return Client
     */
    @CrossOrigin
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public ResponseEntity<ClientEntity> updateClient(@RequestBody ClientEntity client) {
        try {
            clientService.update(client);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ClientEntity> deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
