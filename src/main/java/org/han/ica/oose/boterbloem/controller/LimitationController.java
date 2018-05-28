package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.entity.LimitationEntity;
import org.han.ica.oose.boterbloem.service.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/limitation")
public class LimitationController {
    LimitationService limitationService = new LimitationService();

    @Autowired
    LimitationController() {
        //empty constructor for spring
    }

    /**
     * Method for returning clients
     *
     * @return A arraylist of clients
     */
    @CrossOrigin
    @RequestMapping(value = "/limitations", method = RequestMethod.GET)
    public List<LimitationEntity> getAllLimitations() {
        return limitationService.getAllLimitations();
    }
}