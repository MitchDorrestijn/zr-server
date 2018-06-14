package org.han.ica.oose.boterbloem.security;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtAuthenticationToken;
import org.han.ica.oose.boterbloem.utils.exceptions.JwtTokenNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class is responsable for authenticating the heeaders and JWT for a request
 */
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{

    public JwtAuthenticationTokenFilter() {
        super("/rest/**");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String header = httpServletRequest.getHeader("Authorization");

        if(header == "" || !header.startsWith("Token: ")){
            throw new JwtTokenNotFoundException("JWT NOT FOUND");
        }

        String authenticationToken = header.substring(6);

        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

}
