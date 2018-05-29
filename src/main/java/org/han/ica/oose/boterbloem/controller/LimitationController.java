package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.entity.LimitationEntity;
import org.han.ica.oose.boterbloem.service.ILimitationService;
import org.han.ica.oose.boterbloem.service.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/limitation")
public class LimitationController {
    private static final Logger LOGGER = Logger.getLogger(LimitationController.class.getName());

    private ILimitationService limitationService = new LimitationService();

    @Autowired
    public LimitationController() {
        //Empty constructor for Spring
    }

    @CrossOrigin
    @RequestMapping(value = "/getAllLimitations", method = RequestMethod.GET)
    public List<LimitationEntity> getAll() {
        return limitationService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "getLimitation/{name}", method = RequestMethod.GET)
    public LimitationEntity getByName(@PathVariable String name) {
        return limitationService.getByName(name);
    }

    @CrossOrigin
    @RequestMapping(value = "/addLimitation", method = RequestMethod.POST)
    public void addLimitation(@RequestBody LimitationEntity limitationEntity) {
        limitationService.addLimitation(limitationEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "{name}/edit", method = RequestMethod.PUT)
    public void updateLimitation(@PathVariable String name, @RequestBody LimitationEntity limitationEntity) {
        try {
            LimitationEntity current = limitationService.getByName(name);
            current.setName(limitationEntity.getName());
            limitationService.updateLimitation(current);
        } catch(Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "{name}/delete", method = RequestMethod.DELETE)
    public void deleteLimitation(@PathVariable String name) {
        limitationService.deleteLimitation(name);
    }
}
