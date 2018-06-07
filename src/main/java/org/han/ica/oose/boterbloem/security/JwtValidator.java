package org.han.ica.oose.boterbloem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class validates the JWT form the user
 */
@Component
public class JwtValidator {
    private static final Logger LOGGER = Logger.getLogger(JwtValidator.class.getName());
    SecurityProperties securityProperties = new SecurityProperties();

    /**
     * @param token The token that needs to be validated
     * @return a jwtUser based on the given JWT
     */
    public JwtUser validate(String token) {
        JwtUser jwtUser = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(securityProperties.getSigningkey())
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setRole((String) body.get("role"));
            jwtUser.setCareInstitutionId((int) body.get("careInstitutionId"));
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return jwtUser;
    }
}
