package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.han.ica.oose.boterbloem.Service.ZorginstellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;

@RestController
public class PostZorginstellingController {

    protected static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(DAO.class.getName());

    private ZorginstellingService zorginstellingService;

    @Autowired
    PostZorginstellingController(){

    }

    @CrossOrigin
    @RequestMapping(value = "/zorginstelling/app", method = RequestMethod.POST)

    public ResponseEntity<?> addZorginstelling(@RequestBody Zorginstelling zorginstelling){
        if (zorginstellingService.checkIfExists(zorginstelling)){
            LOGGER.log(Level.SEVERE,"Zorginstelling met deze naam bestaat al" + zorginstelling.getName());
            return new ResponseEntity<Object>(HttpStatus.CONFLICT);
        }

        zorginstellingService.saveZorginstelling(zorginstelling); // slaat het op

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }
}
