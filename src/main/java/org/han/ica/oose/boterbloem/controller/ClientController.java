package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Client;
import org.han.ica.oose.boterbloem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/client")
public class ClientController {

    protected static final Logger LOGGER = Logger.getLogger(DAO.class.getName());
    protected ClientService clientService = new ClientService();

    @Autowired
    ClientController(){
        //empty constructor for spring
    }

    /**Method for returning clients
     *
     * @return A arraylist of clients
     * @throws SQLException
     */
    @CrossOrigin
    @RequestMapping(value = "/clienten", method = RequestMethod.GET)
    public List<Client> getAllCliënten() throws SQLException {
        return clientService.getAllCliënts();
    }

    /**
     * Method for returning a client
     *
     * @param id of Client
     * @return Client
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client getCliëntById(@PathVariable String id) throws SQLException {
        int y = Integer.parseInt(id);
        return clientService.findById(y);
    }

}


