package org.han.ica.oose.boterbloem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.han.ica.oose.boterbloem.dataaccess.daosecurity.JwtUser;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JwtValidator {
    private String secret = "zorgrit";
    private static final Logger LOGGER = Logger.getLogger(JwtValidator.class.getName());


    public JwtUser validate(String token) {
        JwtUser jwtUser = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setPassword((String) body.get("password"));
            jwtUser.setRole((String) body.get("role"));
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return jwtUser;
    }
}
