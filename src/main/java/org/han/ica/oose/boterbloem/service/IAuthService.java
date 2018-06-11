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
     * This method checks id the user from the JWT also exists in the database
     * @param userName the username that needs to be validated
     * @return true if the user exists, false if the user does not exist
     */
    boolean userIsValid(String userName);

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
     * This method finds the user role based on the given user name
     * @param userName the username of the user
     * @return the user role
     */
    String findUserRoleByUsername(String userName);

    /**
     * This method finds the careInstitution that belongs to the user
     * @param userName the username of the user
     * @return the careInstitutionId of the user
     */
    int findCareInstitutionIdByUsername(String userName);

    /**
     * This method gets all the authenticated users
     * @return a list of all authenticated users
     */
    List<JwtUser> getAllAuthenticatedUsers();

    /**
     * This method removes a authenticated user based on the given username
     * @param userName the username that needs to be removed
     */
    void deleteAuthenticatedUser(String userName);

}
