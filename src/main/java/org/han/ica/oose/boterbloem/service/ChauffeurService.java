package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.ChauffeurDAO;
import org.han.ica.oose.boterbloem.domain.Chauffeur;

import java.util.List;

public class ChauffeurService implements IChauffeurService {
    ChauffeurDAO chauffeurDAO = new ChauffeurDAO();

    public ChauffeurService() {
    }

    @Override
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurDAO.getAllChauffeurs();
    }

}
