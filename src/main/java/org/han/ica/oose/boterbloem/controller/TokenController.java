package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.security.JwtGenerator;
import org.han.ica.oose.boterbloem.service.IAuthService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TokenController {
    private JwtGenerator jwtGenerator;
    protected IAuthService authService = new AuthService();


    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @RequestMapping("/login")
    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){
        return jwtGenerator.generate(jwtUser);
    }

    @RequestMapping(value = "/tokenExists", method = RequestMethod.GET)
    public boolean tokenExists(@RequestParam("token") String token) {
        return authService.tokenExists(token);
    }

}
