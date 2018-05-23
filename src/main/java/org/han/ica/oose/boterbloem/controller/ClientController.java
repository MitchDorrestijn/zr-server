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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService = new ClientService();

    @Autowired
    ClientController() {
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
    public ResponseEntity <ClientEntity> updateClient(@PathVariable int id, @RequestBody ClientEntity client) {
        clientService.findById(id);
        clientService.updateClient(client);
        return new ResponseEntity <>(client, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity <ClientEntity> deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return new ResponseEntity <>(HttpStatus.NO_CONTENT);
    }
}
