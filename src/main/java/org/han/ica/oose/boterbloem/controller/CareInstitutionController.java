package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.security.AdminAndCareInstitutionAuthorization;
import org.han.ica.oose.boterbloem.security.AdminAuthorization;
import org.han.ica.oose.boterbloem.service.ICareInstitutionService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.CareInstitutionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/zorginstelling")
public class CareInstitutionController {

    private ICareInstitutionService careInstitutionService = new CareInstitutionService();

    CareInstitutionController() {
        // Empty Constructor for Spring
    }

    /**
     * GET CarInstitution by Id
     * @param id of CarInstitution
     * @return CarInstitution
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<CareinstitutionEntity> getCareInstitutionById(@PathVariable int id) {
        List<CareinstitutionEntity> careinstitutionEntities =  new ArrayList<>();
        careinstitutionEntities.add(careInstitutionService.findById(id));
        return careinstitutionEntities;
    }

    /**
     * GET all CareInstitutions
     * @return list of CareInstitutions
     */
    @AdminAuthorization
    @RequestMapping(value = "/zorginstellingen", method = RequestMethod.GET)
    public List <CareInstitution> getAllCareInstitutions() {
        return careInstitutionService.getAllCareInstitutions();
    }

    /**
     * POST new CareInstitution
     * @param careInstitution =  new CareInstitution
     */
    @AdminAuthorization
    @RequestMapping(value = "/addZorginstelling", method = RequestMethod.POST)
    public void addCareInstitution(@RequestBody CareInstitution careInstitution) {
        careInstitutionService.saveCareInstitution(careInstitution);
    }

    /**
     * UPDATE CareInstitution
     * @param id of CareInstitution
     * @param careInstitution =  CareInstitution
     */
    @AdminAuthorization
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public void updateCareInstitution(@PathVariable int id, @RequestBody CareInstitution careInstitution) {
        careInstitution.setId(id);
        careInstitutionService.updateCareInstitution(careInstitution);
    }

    /**
     * DELETE CareInstitution by Id
     * @param id of CareInstitution
     */
    @AdminAuthorization
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCareInstitutionById(@PathVariable int id) {
        careInstitutionService.deleteCareInstitutionById(id);
    }
    
    /**
     * Getter for property 'careInstitutionService'.
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