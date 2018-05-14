package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Chauffeur;
import org.han.ica.oose.boterbloem.service.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chauffeur")
public class ChauffeurController {

    protected static final Logger LOGGER = Logger.getLogger(DAO.class.getName());

    protected ChauffeurService chauffeurService = new ChauffeurService();

    @Autowired
    ChauffeurController() {
    }
    
    @RequestMapping(value = "/chauffeurs", method = RequestMethod.GET)
    public List<Chauffeur> getAllChauffeurs() {
        List <Chauffeur> chauffeurs = new ArrayList<>();
        chauffeurs = chauffeurService.getAllChauffeurs();
        return chauffeurs;
    }
}
