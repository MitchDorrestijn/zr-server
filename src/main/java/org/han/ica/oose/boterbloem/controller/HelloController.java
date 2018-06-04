package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.service.IAuthService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.AuthService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest")
public class HelloController {

    protected IAuthService authService = new AuthService();

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public String hello(){
        return "Hello, world";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/addAuthenticatedUser", method = RequestMethod.POST)
    public void addAuthenticatedUser(@RequestBody JwtUser jwtUser){
        authService.createAuthenticatedUser(jwtUser);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ZORGINSTELLING')")
    @RequestMapping(value = "/alternative", method = RequestMethod.GET)
    public String test(){
        return "test";
    }
}
