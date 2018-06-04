package org.han.ica.oose.boterbloem.security;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtAuthenticationToken;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUserDetails;
import org.han.ica.oose.boterbloem.service.serviceimplementation.AuthService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator validator;
    AuthService authService = new AuthService();


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        if (authService.userIsValid(userDetails.getUsername(), userDetails.getPassword()) == false) {
            throw new RuntimeException("Gebruiker bestaat niet of credentials zijn ongeldig");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        System.out.println("In JwtAuthenticationProvider");
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();
        JwtUser jwtUser = validator.validate(token);

        if(jwtUser == null){
            throw new RuntimeException("Jwt token klopt niet");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());

        return new JwtUserDetails(jwtUser.getUserName(), jwtUser.getPassword(), token, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
