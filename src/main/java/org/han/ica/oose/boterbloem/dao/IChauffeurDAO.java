package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Chauffeur;

import java.util.List;

public interface IChauffeurDAO {

    /***
     * @return All chauffeurs and their properties fetched from the database
     */
    List<Chauffeur> getAllChauffeurs();
}