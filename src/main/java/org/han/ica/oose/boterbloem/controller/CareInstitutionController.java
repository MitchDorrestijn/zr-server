package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.service.ICareInstitutionService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.CareInstitutionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/zorginstelling")
public class CareInstitutionController {

    private ICareInstitutionService careInstitutionService = new CareInstitutionService();

    @Autowired
    CareInstitutionController() {
        // Empty Constructor for Spring
    }

    /**
     * GET CarInstitution by Id
     * @param id of CarInstitution
     * @return CarInstitution
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CareinstitutionEntity getCareInstitutionById(@PathVariable int id) {
        return careInstitutionService.findById(id);
    }

    /**
     * GET all CareInstitutions
     * @return list of CareInstitutions
     */
    @RequestMapping(value = "/zorginstellingen", method = RequestMethod.GET)
    public List <CareInstitution> getAllCareInstitutions() {
        return careInstitutionService.getAllCareInstitutions();
    }

    /**
     * POST new CareInstitution
     * @param careInstitution =  new CareInstitution
     */
    @RequestMapping(value = "/addZorginstelling", method = RequestMethod.POST)
    public void addCareInstitution(@RequestBody CareInstitution careInstitution) {
        careInstitutionService.saveCareInstitution(careInstitution);
    }

    /**
     * UPDATE CareInstitution
     * @param id of CareInstitution
     * @param careInstitution =  CareInstitution
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public void updateCareInstitution(@PathVariable int id, @RequestBody CareInstitution careInstitution) {
        careInstitution.setId(id);
        careInstitutionService.updateCareInstitution(careInstitution);
    }

    /**
     * DELETE CareInstitution by Id
     * @param id of CareInstitution
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCareInstitutionById(@PathVariable int id) {
        careInstitutionService.deleteCareInstitutionById(id);
    }

}