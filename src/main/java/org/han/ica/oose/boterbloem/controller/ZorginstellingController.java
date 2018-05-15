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
        // empty constructor
    }

    /**
     * @param zorginstelling Zorginstelling
     * @return new Zorginstelling
     */
    @CrossOrigin
    @RequestMapping(value = "/addZorginstelling", method = RequestMethod.POST)

    public ResponseEntity<String> addZorginstelling(@RequestBody Zorginstelling zorginstelling) {
        zorginstellingService.updateCareInstitution(zorginstelling);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
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
        return zorginstellingService.findById(y);
    }

    /**
     * Method for returning all zorginstellignen
     *
     * @return List of zorginstellingen
     */
    @RequestMapping(value = "/zorginstellingen", method = RequestMethod.GET)
    public List<Zorginstelling> getAllZorginstelling() {
        return zorginstellingService.getAllZorginstellingen();
    }

    /**
     * @param id             of Zorginstelling
     * @param zorginstelling Zorginstelling
     * @return Zorginstelling
     */
    @CrossOrigin
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)

    public ResponseEntity<Zorginstelling> updateZorginstelling(@PathVariable int id, @RequestBody Zorginstelling zorginstelling) {
        Zorginstelling currentZorginstellling = null;
        try {
            currentZorginstellling = zorginstellingService.findById(id);
            currentZorginstellling.setName(zorginstelling.getName());
            zorginstellingService.updateZorginstelling(currentZorginstellling);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        return new ResponseEntity<>(currentZorginstellling, HttpStatus.OK);

    }

    /**
     * @param id of Zorginstelling
     * @return Zorginstelling with HttpStatus.NO_CONTENT
     */
    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Zorginstelling> deleteZorginstelling(@PathVariable int id) {
        zorginstellingService.deleteZorginstellingById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}