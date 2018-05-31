package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.domainObjects.CareInstitution;
import org.han.ica.oose.boterbloem.dataAccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.service.serviceImplementation.CareInstitutionService;
import org.han.ica.oose.boterbloem.dataAccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.service.serviceImplementation.CareInstitutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/zorginstelling")
public class CareInstitutionController {

    protected static final Logger LOGGER = Logger.getLogger(CareInstitutionController.class.getName());

    CareInstitutionService careInstitutionService = new CareInstitutionService();

    CareInstitutionController() {
        // empty constructor
    }

    /**
     * @param careInstitution ICareInstitution
     * @return new ICareInstitution
     */
    @CrossOrigin
    @RequestMapping(value = "/addZorginstelling", method = RequestMethod.POST)
    public void addCareInstitution(@RequestBody CareInstitution careInstitution) {
        careInstitutionService.saveCareInstitution(careInstitution);
    }

    /**
     * Method for returning a ICareInstitution
     *
     * @param id of ICareInstitution
     * @return ICareInstitution
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CareinstitutionEntity getCareInstitution(@PathVariable int id) {

        return careInstitutionService.findById(id);
    }

    /**
     * Method for returning all ICareInstitution
     *
     * @return List of ICareInstitution
     */
    @RequestMapping(value = "/zorginstellingen", method = RequestMethod.GET)
    public List<CareInstitution> getAllCareInstitutions() {
        return careInstitutionService.getAllCareInstitutions();
    }

    /**
     * @param id              of ICareInstitution
     * @param careInstitution ICareInstitution
     * @return ICareInstitution
     */
    @CrossOrigin
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public void updateCareInstitution(@PathVariable int id, @RequestBody CareInstitution careInstitution) {
            careInstitution.setId(id);
            careInstitutionService.updateCareInstitution(careInstitution);
    }

    /**
     * @param id of ICareInstitution
     * @return ICareInstitution with HttpStatus.NO_CONTENT
     */
    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CareinstitutionEntity> deleteCareInstitution(@PathVariable int id) {
        careInstitutionService.deleteCareInstitutionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}