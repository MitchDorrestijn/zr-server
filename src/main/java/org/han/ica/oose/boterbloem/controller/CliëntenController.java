package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Client;
import org.han.ica.oose.boterbloem.service.CliëntenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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

    /**Method for returning cliënts
     *
     * @return A arraylist of cliënts
     * @throws SQLException
     */
    @CrossOrigin
    @RequestMapping(value = "/cliënten", method = RequestMethod.GET)
    public List<Client> getAllCliënten() throws SQLException {
        return cliëntenService.getAllCliënts();
    }

    /**
     * Method for returning a cliënt
     *
     * @param id of Cliënt
     * @return Cliënt
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client getCliëntById(@PathVariable String id) throws SQLException {
        int y = Integer.parseInt(id);
        return cliëntenService.findById(y);
    }

}


