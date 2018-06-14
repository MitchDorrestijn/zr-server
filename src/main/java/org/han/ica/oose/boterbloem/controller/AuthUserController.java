package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.security.AdminAuthorization;
import org.han.ica.oose.boterbloem.service.IAuthService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/authentication")
public class AuthUserController {
    protected IAuthService authService = new AuthService();

    /**
     * The endpoint to add a new authenticated user
     * @param jwtUser the user that needs to be added as authenticated user
     */
    @AdminAuthorization
    @RequestMapping(value = "/addAuthenticatedUser", method = RequestMethod.POST)
    public void addAuthenticatedUser(@RequestBody JwtUser jwtUser){
        authService.createAuthenticatedUser(jwtUser);
    }

    /**
     * The endpoint to get all authenticated users
     * @return a list of all authenticated users
     */
    @AdminAuthorization
    @RequestMapping(value = "/getAllAuthenticatedUsers", method = RequestMethod.GET)
    public List<JwtUser> getAllAuthenticatedUsers() {
        return authService.getAllAuthenticatedUsers();
    }

    /**
     * DELETE existing authenticated user
     * @param userName of the authenticated user
     */
    @AdminAuthorization
    @RequestMapping(value = "/{userName}/delete", method = RequestMethod.DELETE)
    public void deleteAuthenticatedUser(@PathVariable String userName) {
        authService.deleteAuthenticatedUser(userName);
    }

    /**
     * Setter for property 'authService'.
     *
     * @param authService Value to set for property 'authService'.
     */
    public void setAuthService(IAuthService authService) {
        this.authService = authService;
    }
}
