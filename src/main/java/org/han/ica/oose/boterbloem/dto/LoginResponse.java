package org.han.ica.oose.boterbloem.dto;

/**
 * Representative DTO for a LoginResponse
 */
public class LoginResponse {

    protected String user;
    protected String token;
    protected String administratorLevel;

    public LoginResponse(String user, String token, String administratorLevel) {
        this.user = user;
        this.token = token;
        this.administratorLevel = administratorLevel;
    }
}
