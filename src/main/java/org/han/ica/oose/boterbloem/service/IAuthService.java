package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;

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
     * This method finds the user role based on the given user credentials
     * @param userName the username of the user
     * @param password the bassword of the user
     * @return the user role
     */
    String findUserRoleByUsernameAndPassword(String userName, String password);

    /**
     * This method finds the careInstitution that belongs to the user
     * @param userName the username of the user
     * @param password the password of the user
     * @return the careInstitutionId of the user
     */
    int findCareInstitutionIdByUsernameAndPassword(String userName, String password);
}
