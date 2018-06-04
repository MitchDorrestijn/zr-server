package org.han.ica.oose.boterbloem.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JwtSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger LOGGER = Logger.getLogger(JwtSuccessHandler.class.getName());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("In JwtSuccessHandler");
        LOGGER.log(Level.INFO, "Succesvol geauthenticeerd");

    }
}
