package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;
import org.han.ica.oose.boterbloem.service.IUtilityService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/utility")
public class UtilityController {
    private IUtilityService utilityService = new UtilityService();

    @Autowired
    UtilityController() {
        //empty constructor for spring
    }

    /**
     * GET all Utilities from the database
     * @return list of Utilities
     */
    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ZORGINSTELLING')")
    @RequestMapping(value = "/all/utilities", method = RequestMethod.GET)
    public List<Utility> getAllUtilities() {
        return utilityService.getAllUtilities();
    }
}
