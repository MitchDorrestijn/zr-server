package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.han.ica.oose.boterbloem.service.ZorginstellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.logging.Level;

@RestController
public class ZorginstellingController {

    protected static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(DAO.class.getName());

    private ZorginstellingService zorginstellingService = new ZorginstellingService();

    @Autowired
    ZorginstellingController(){

    }

    @CrossOrigin
    @RequestMapping(value = "/zorginstelling/addZorginstelling", method = RequestMethod.POST)

    public ResponseEntity<?> addZorginstelling(@RequestBody Zorginstelling zorginstelling){

      /*  if (zorginstellingService.checkIfExists(zorginstelling)){
            LOGGER.log(Level.SEVERE,"Zorginstelling met deze naam bestaat al " + zorginstelling.getName());
            return new ResponseEntity<Object>(HttpStatus.CONFLICT);
        }*/

        zorginstellingService.saveZorginstelling(zorginstelling);


        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
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
