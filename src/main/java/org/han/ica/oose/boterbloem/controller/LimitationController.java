package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.entity.LimitationEntity;
import org.han.ica.oose.boterbloem.service.ILimitationService;
import org.han.ica.oose.boterbloem.service.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/limitation")
public class LimitationController {
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
}
