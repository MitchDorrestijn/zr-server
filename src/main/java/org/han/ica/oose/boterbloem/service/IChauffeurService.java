package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.Chauffeur;

import java.util.List;

public interface IChauffeurService {

    /***
     * @return A list of all chauffeurs and their properties
     */
    List<Chauffeur> getAllChauffeurs();
}
