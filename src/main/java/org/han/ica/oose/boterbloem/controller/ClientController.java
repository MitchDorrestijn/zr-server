package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dao.ConnectionDAO;
import org.han.ica.oose.boterbloem.domain.Client;
import org.han.ica.oose.boterbloem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {
    protected static final Logger LOGGER = Logger.getLogger(ConnectionDAO.class.getName());

    protected ClientService clientService = new ClientService();

    @Autowired
    public ClientController() {
        //Empty constructor
    }

    /**
     * @param client client to be added
     * @return new client
     */
    @CrossOrigin
    @RequestMapping(value = "/addClient", method = RequestMethod.POST)

    public ResponseEntity<String> addZorginstelling(@RequestBody Client client) {
        clientService.createClient(client);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
