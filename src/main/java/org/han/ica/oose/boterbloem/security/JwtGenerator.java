package org.han.ica.oose.boterbloem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.service.serviceimplementation.AuthService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    AuthService authService = new AuthService();

    public String generate(JwtUser jwtUser) {
        System.out.println("In JwtGenerator");
        if (authService.userIsValid(jwtUser.getUserName(), jwtUser.getPassword())) {
            jwtUser.setRole(authService.findUserRoleByUsernameAndPassword(jwtUser.getUserName(), jwtUser.getPassword()));
            jwtUser.setCareInstitutionId(authService.findCareInstitutionIdByUsernameAndPassword(jwtUser.getUserName(), jwtUser.getPassword()));

            Claims claims = Jwts.claims()
                    .setSubject(jwtUser.getUserName());
            claims.put("password", jwtUser.getPassword());
            claims.put("role", jwtUser.getRole());
            claims.put("careInstitutionId", jwtUser.getCareInstitutionId());

            String theToken = Jwts.builder()
                                .setClaims(claims)
                                .signWith(SignatureAlgorithm.HS512, "zorgrit")
                                .compact();

            jwtUser.setLatestToken(theToken);
            authService.updateToken(jwtUser);

            return theToken;
        } else {
         throw new RuntimeException("Gebruiker bestaat niet of credentials zijn ongeldig");
        }
    }
}
