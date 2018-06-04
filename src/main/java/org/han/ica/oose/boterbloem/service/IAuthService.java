package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;

public interface IAuthService {
    void createAuthenticatedUser(JwtUser jwtUser);
    boolean userIsValid(String userName, String password);
    void updateToken(JwtUser jwtUser);

    boolean tokenExists(String token);

    String findUserRoleByUsernameAndPassword(String userName, String password);

    int findCareInstitutionIdByUsernameAndPassword(String userName, String password);
}
