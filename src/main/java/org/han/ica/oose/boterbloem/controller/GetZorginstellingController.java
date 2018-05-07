package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.Service.ZorginstellingService;
import org.han.ica.oose.boterbloem.dao.DAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


/**
 * Class for getting a zorginstelling
 */
@Controller
@RequestMapping("/zorginstelling")
public class GetZorginstellingController {
    protected static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(DAO.class.getName());

    private ZorginstellingService zorginstellingService = new ZorginstellingService();

    /**
     * Method for returning a zorginstelling
     *
     * @param id
     * @return Zorginstelling
     */
    @CrossOrigin
    @RequestMapping(value = "/zorginstelling/{id}", method = RequestMethod.GET)
    public Zorginstelling getZorginstelling(@PathVariable int id) throws SQLException {

        Zorginstelling zorginstelling = new Zorginstelling();
        try {
            zorginstelling = zorginstellingService.findById(id);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return zorginstelling;
    }

    /**
     * Method for returning all zorginstellignen
     *
     * @return List of zorginstellingen
     * @throws SQLException
     */
    @CrossOrigin
    @RequestMapping(value = "/zorginstelling/zorginstellingen", method = RequestMethod.GET)
    public List<Zorginstelling> getAllZorginstelling() throws SQLException {
        List<Zorginstelling> zorginstellingen = new ArrayList<>();
        try {
            zorginstellingen = zorginstellingService.getAllZorginstellingen();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return zorginstellingen;
    }

}
