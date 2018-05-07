package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dao.IZorginstellingDAO;
import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.han.ica.oose.boterbloem.util.exceptions.ZorginstellingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Class for getting a zorginstelling
 */
@Controller
@RequestMapping("/zorginstelling")
public class GetZorginstellingController {


    IZorginstellingDAO zorginstellingDAO = new ZorginstellingDAO();


    /**
     * Method for returning a zorginstelling
     *
     * @param id
     * @return Zorginstelling
     */
    @RequestMapping(value = "/zorginstelling/{id}", method = RequestMethod.GET)
    public Zorginstelling getZorginstelling(@PathVariable int id) throws ZorginstellingNotFoundException {
        Zorginstelling zorginstelling;
        zorginstelling = zorginstellingDAO.getByID(id);
        if (zorginstelling == null) {
            throw new ZorginstellingNotFoundException(id);
        }

        return zorginstelling;
    }

    @RequestMapping(value = "/zorginstelling/zorginstellingen", method = RequestMethod.GET)
    public List<Zorginstelling> getAllZorginstelling() throws ZorginstellingNotFoundException {
        List<Zorginstelling> zorginstellingen;
        zorginstellingen = zorginstellingDAO.getAllZorginstellingen();
        return zorginstellingen;
    }

}
