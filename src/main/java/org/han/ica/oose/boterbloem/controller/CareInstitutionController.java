package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.service.ICareInstitutionService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.CareInstitutionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/zorginstelling")
public class CareInstitutionController {

    private ICareInstitutionService careInstitutionService = new CareInstitutionService();

    /** Constructs a new CareInstitutionController. */
    @Autowired
    CareInstitutionController() {
        // Empty Constructor for Spring
    }

    /**
     * GET CarInstitution by Id
     * @param id of CarInstitution
     * @return CarInstitution
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ZORGINSTELLING')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CareinstitutionEntity getCareInstitutionById(@PathVariable int id) {
        return careInstitutionService.findById(id);
    }

    /**
     * GET all CareInstitutions
     * @return list of CareInstitutions
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/zorginstellingen", method = RequestMethod.GET)
    public List <CareInstitution> getAllCareInstitutions() {
        return careInstitutionService.getAllCareInstitutions();
    }

    /**
     * POST new CareInstitution
     * @param careInstitution =  new CareInstitution
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ZORGINSTELLING')")
    @RequestMapping(value = "/addZorginstelling", method = RequestMethod.POST)
    public void addCareInstitution(@RequestBody CareInstitution careInstitution) {
        careInstitutionService.saveCareInstitution(careInstitution);
    }

    /**
     * UPDATE CareInstitution
     * @param id of CareInstitution
     * @param careInstitution =  CareInstitution
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ZORGINSTELLING')")
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public void updateCareInstitution(@PathVariable int id, @RequestBody CareInstitution careInstitution) {
        careInstitution.setId(id);
        careInstitutionService.updateCareInstitution(careInstitution);
    }

    /**
     * DELETE CareInstitution by Id
     * @param id of CareInstitution
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ZORGINSTELLING')")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCareInstitutionById(@PathVariable int id) {
        careInstitutionService.deleteCareInstitutionById(id);
    }
    
    /**
     * Getter for property 'careInstitutionService'.
     *
     * @return Value for property 'careInstitutionService'.
     */
    public ICareInstitutionService getCareInstitutionService() {
        return careInstitutionService;
    }

    /**
     * Setter for property 'careInstitutionService'.
     *
     * @param careInstitutionService Value to set for property 'careInstitutionService'.
     */
    public void setCareInstitutionService(ICareInstitutionService careInstitutionService) {
        this.careInstitutionService = careInstitutionService;
    }

}