package org.han.ica.oose.boterbloem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.service.serviceimplementation.AuthService;
import org.han.ica.oose.boterbloem.utils.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

/**
 * This class generates a JWT for a user
 */
@Component
public class JwtGenerator {
    AuthService authService = new AuthService();
    SecurityProperties securityProperties = new SecurityProperties();

    /**
     * This method generates a JWT for the necessary properties in JwtUser
     * @param jwtUser the user that needs a token
     * @return a new JWT
     */
    public String generate(JwtUser jwtUser) {
        jwtUser = authService.findByUsername(jwtUser.getUserName());

        if (jwtUser.getRole() != null) {
            Claims claims = Jwts.claims()
                    .setSubject(jwtUser.getUserName());
            claims.put("role", jwtUser.getRole());
            claims.put("careInstitutionId", jwtUser.getCareInstitutionId());

            String theToken = Jwts.builder()
                                .setClaims(claims)
                                .signWith(SignatureAlgorithm.HS512, securityProperties.getSigningkey())
                                .compact();

            jwtUser.setLatestToken(theToken);
            authService.updateToken(jwtUser);

            return theToken;
        } else {
            throw new UserNotFoundException("USER DOES NOT EXIST OR CREDENTIALS ARE NOT VALID");
        }
    }

    /**
     * Setter for property 'authService'.
     *
     * @param authService Value to set for property 'authService'.
     */
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Setter for property 'securityProperties'.
     *
     * @param securityProperties Value to set for property 'securityProperties'.
     */
    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
