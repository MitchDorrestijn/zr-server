package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {
    protected static final Logger LOGGER = Logger.getLogger(CareInstitutionController.class.getName());

    protected ClientService clientService = new ClientService();

    /**
     * @param client client to be added
     * @return new client
     */
    @CrossOrigin
    @RequestMapping(value = "/addClient", method = RequestMethod.POST)

    public ResponseEntity<String> addClient(@RequestBody ClientEntity client) {
        clientService.createClient(client);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @Autowired
    ClientController() {
        //empty constructor for spring
    }

    /**
     * Method for returning clients
     *
     * @return A arraylist of clients
     * @throws SQLException
     */
    @CrossOrigin
    @RequestMapping(value = "/clienten", method = RequestMethod.GET)
    public List<ClientEntity> getAllClienten() throws SQLException {
        return clientService.getAllClients();
    }

    /**
     * Method for returning a client
     *
     * @param id of Client
     * @return Client
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientEntity getClietById(@PathVariable int id) throws SQLException {
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
}
