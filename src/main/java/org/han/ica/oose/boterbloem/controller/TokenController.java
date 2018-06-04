package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dataaccess.daosecurity.JwtUser;
import org.han.ica.oose.boterbloem.security.JwtGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){
        return jwtGenerator.generate(jwtUser);
    }
}
