package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.dataaccess.entities.LimitationEntity;
import org.han.ica.oose.boterbloem.security.AdminAndCareInstitutionAuthorization;
import org.han.ica.oose.boterbloem.security.AdminAuthorization;
import org.han.ica.oose.boterbloem.service.ILimitationService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/limitation")
public class LimitationController {
    private static final Logger LOGGER = Logger.getLogger(LimitationController.class.getName());
    private ILimitationService limitationService = new LimitationService();

    @Autowired
    public LimitationController() {
        //Empty constructor for Spring
    }

    /**
     * GET specific limitation from the database
     * @param name of Limitation
     * @return Limitation
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "getLimitation/{name}", method = RequestMethod.GET)
    public LimitationEntity getByName(@PathVariable String name) {
        return limitationService.getLimitationByName(name);
    }

    /**
     * GET all limitations from the database
     * @return list of Limitations
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/getAllLimitations", method = RequestMethod.GET)
    public List<LimitationEntity> getAllLimitations() {
        return limitationService.getAllLimitations();
    }


    /**
     * POST new limitation to the database
     * @param limitationEntity = new Limitation
     */
    @AdminAuthorization
    @RequestMapping(value = "/addLimitation", method = RequestMethod.POST)
    public void addLimitation(@RequestBody LimitationEntity limitationEntity) {
        limitationService.addLimitation(limitationEntity);
    }

    /**
     * UPDATE existing limitation
     * @param name of Limitation
     * @param limitationEntity = Limitation
     */
    @AdminAuthorization
    @RequestMapping(value = "{name}/edit", method = RequestMethod.PUT)
    public void updateLimitation(@PathVariable String name, @RequestBody LimitationEntity limitationEntity) {
        try {
            LimitationEntity current = limitationService.getLimitationByName(name);
            current.setName(limitationEntity.getName());
            limitationService.updateLimitation(current);
        } catch(Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    /**
     * DELETE existing limitation
     * @param name of Limitation
     */
    @AdminAuthorization
    @RequestMapping(value = "{name}/delete", method = RequestMethod.DELETE)
    public void deleteLimitation(@PathVariable String name) {
        limitationService.deleteLimitation(name);
    }
}
