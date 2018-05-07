package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.Service.ZorginstellingService;
import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.han.ica.oose.boterbloem.Service.ZorginstellingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.logging.Level;

@RestController
public class EditZorginstellingController {
    protected static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(DAO.class.getName());

    private ZorginstellingService zorginstellingService;

    @Autowired
    EditZorginstellingController(){

    }

    @CrossOrigin
    @RequestMapping(value = "/zorginstelling/{id}/edit", method = RequestMethod.PUT)


    public ResponseEntity<?> updateUser(@PathVariable int  id, @RequestBody Zorginstelling zorginstelling) {

        Zorginstelling currentZorginstellling = null;

        try {
            currentZorginstellling = zorginstellingService.findById(id);
            currentZorginstellling.setName(zorginstelling.getName());
            zorginstellingService.updateZorginstelling(currentZorginstellling);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        return new ResponseEntity<Zorginstelling>(currentZorginstellling, HttpStatus.OK);
    }
}