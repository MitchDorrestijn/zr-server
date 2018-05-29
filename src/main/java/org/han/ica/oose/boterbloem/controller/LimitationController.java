package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.ILimitationService;
import org.han.ica.oose.boterbloem.service.LimitationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/limitation")
public class LimitationController {
    private ILimitationService limitationService = new LimitationService();

    
}
