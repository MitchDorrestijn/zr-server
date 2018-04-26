package org.han.ica.oose.boterbloem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

    @RequestMapping(value = "/pong", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public String pong() {
        return "pong";
    }
}
