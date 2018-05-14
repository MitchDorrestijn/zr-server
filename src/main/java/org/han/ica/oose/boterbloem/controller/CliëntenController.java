package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/cliënt")
public class CliëntenController {

    protected static final Logger LOGGER = Logger.getLogger(DAO.class.getName());
    protected CliëntenService cliëntenService = new CliëntenService();

    @Autowired
    CliëntenController(){
        //empty constructor for spring
    }

    @CrossOrigin
    @RequestMapping(value = "/cliënten", method = RequestMethod.GET)
    public List<Client> getAllCliënten(){
        return cliëntenService.getAllCliënten();
    }

}


