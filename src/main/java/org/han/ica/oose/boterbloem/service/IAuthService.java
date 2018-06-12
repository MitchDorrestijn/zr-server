package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;

import java.util.List;

public interface IAuthService {

    /**
     * This method creates a new authenticated user
     * @param jwtUser the user that needs to be added as authenticated user
     */
    void createAuthenticatedUser(JwtUser jwtUser);

    /**
     * This method updates the latest token for the jwtUser in the database
     * @param jwtUser the user that needs an updated token
     */
    void updateToken(JwtUser jwtUser);

    /**
     * This method checks if the token exists in the database
     * @param token the token that needs to be checked upon
     * @return tru if the token exists, false if the token does not exist
     */
    boolean tokenExists(String token);

    /**
     * This method get all info from a given username
     * @param userName the username that needs to be checked upon
     * @return all info from a given username
     */
    JwtUser findByUsername(String userName);

    /**
     * This method gets all the authenticated users
     * @return a list of all authenticated users
     */
    List<JwtUser> getAllAuthenticatedUsers();

    /**
     * This method removes a given authuser
     * @param userName the username that needs to be removed
     */
    void deleteAuthenticatedUser(String userName);
}
