package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dao.ConnectionDAO;
import org.han.ica.oose.boterbloem.domain.CareInstitution;
import org.han.ica.oose.boterbloem.service.CareInstitutionService;
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
public class CareInstitutionController {

    protected static final Logger LOGGER = Logger.getLogger(ConnectionDAO.class.getName());

    protected CareInstitutionService careInstitutionService = new CareInstitutionService();

    @Autowired
    CareInstitutionController() {
        // empty constructor
    }

    /**
     * @param careInstitution CareInstitution
     * @return new CareInstitution
     */
    @CrossOrigin
    @RequestMapping(value = "/addZorginstelling", method = RequestMethod.POST)

    public ResponseEntity<String> addCareInstitution(@RequestBody CareInstitution careInstitution) {
        careInstitutionService.saveCareInstitution(careInstitution);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * Method for returning a CareInstitution
     *
     * @param id of CareInstitution
     * @return CareInstitution
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CareInstitution getCareInstitution(@PathVariable String id) {
        int y = Integer.parseInt(id);
        return careInstitutionService.findById(y);
    }

    /**
     * Method for returning all CareInstitution
     *
     * @return List of CareInstitution
     */
    @RequestMapping(value = "/zorginstellingen", method = RequestMethod.GET)
    public List<CareInstitution> getAllCareInstitutions() {
        return careInstitutionService.getAllCareInstitutions();
    }

    /**
     * @param id             of CareInstitution
     * @param careInstitution CareInstitution
     * @return CareInstitution
     */
    @CrossOrigin
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)

    public ResponseEntity<CareInstitution> updateCareInstitution(@PathVariable int id, @RequestBody CareInstitution careInstitution) {
        CareInstitution currentCareInstitution = null;
        try {
            currentCareInstitution = careInstitutionService.findById(id);
            currentCareInstitution.setName(careInstitution.getName());
            careInstitutionService.updateCareInstitution(currentCareInstitution);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        return new ResponseEntity<>(currentCareInstitution, HttpStatus.OK);

    }

    /**
     * @param id of CareInstitution
     * @return CareInstitution with HttpStatus.NO_CONTENT
     */
    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CareInstitution> deleteCareInstitution(@PathVariable int id) {
        careInstitutionService.deleteCareInstitutionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}