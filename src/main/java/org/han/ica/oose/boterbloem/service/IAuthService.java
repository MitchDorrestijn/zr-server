package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;

public interface IAuthService {
    void createAuthenticatedUser(JwtUser jwtUser);
    boolean userIsValid(String userName, String password);
}
