package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.han.ica.oose.boterbloem.service.ZorginstellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/zorginstelling")
public class ZorginstellingController {

    protected static final Logger LOGGER = Logger.getLogger(DAO.class.getName());

    protected ZorginstellingService zorginstellingService = new ZorginstellingService();

    @Autowired
    ZorginstellingController() {

    }

    /**
     * @param zorginstelling Zorginstelling
     * @return new Zorginstelling
     */
    @CrossOrigin
    @RequestMapping(value = "/addZorginstelling", method = RequestMethod.POST)
    public ResponseEntity <?> addZorginstelling(@RequestBody Zorginstelling zorginstelling) {
//        if (zorginstellingService.checkIfExists(zorginstelling)) {
//            LOGGER.log(Level.SEVERE, "Zorginstelling met deze naam bestaat al " + zorginstelling.getName());
//            return new ResponseEntity <Object>(HttpStatus.CONFLICT);
//        }

        zorginstellingService.saveZorginstelling(zorginstelling);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity <String>(headers, HttpStatus.CREATED);
    }

    /**
     * Method for returning a zorginstelling
     *
     * @param id of Zorginstelling
     * @return Zorginstelling
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Zorginstelling getZorginstelling(@PathVariable String id) {
        int y = Integer.parseInt(id);
        Zorginstelling zorginstelling = new Zorginstelling();
        zorginstelling = zorginstellingService.findById(y);
        return zorginstelling;
    }

    /**
     * Method for returning all zorginstellignen
     *
     * @return List of zorginstellingen
     */
    @RequestMapping(value = "/zorginstellingen", method = RequestMethod.GET)
    public List <Zorginstelling> getAllZorginstelling() {
        List <Zorginstelling> zorginstellingen = new ArrayList <>();
        zorginstellingen = zorginstellingService.getAllZorginstellingen();
        return zorginstellingen;
    }

    /**
     * @param id of Zorginstelling
     * @param zorginstelling Zorginstelling
     * @return Zorginstelling
     */
    @CrossOrigin
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public ResponseEntity <?> updateZorginstelling(@PathVariable int id, @RequestBody Zorginstelling zorginstelling) {
        Zorginstelling currentZorginstellling = null;
        try {
            currentZorginstellling = zorginstellingService.findById(id);
            currentZorginstellling.setName(zorginstelling.getName());
            zorginstellingService.updateZorginstelling(currentZorginstellling);
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return new ResponseEntity <Zorginstelling>(currentZorginstellling, HttpStatus.OK);
    }

    /**
     * @param id of Zorginstelling
     * @return Zorginstelling with HttpStatus.NO_CONTENT
     */
    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity <?> deleteZorginstelling(@PathVariable int id) {
        Zorginstelling zorginstelling = zorginstellingService.findById(id);
        if (zorginstelling == null) {
            LOGGER.info("Unable to delete. Zorginstelling with id not found." + id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        zorginstellingService.deleteZorginstellingById(zorginstelling);
        return new ResponseEntity <Zorginstelling>(HttpStatus.NO_CONTENT);
    }
}
