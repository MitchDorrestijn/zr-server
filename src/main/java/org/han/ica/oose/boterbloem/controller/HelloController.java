package org.han.ica.oose.boterbloem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public String hello(){
        return "Hello, world";
    }
}
