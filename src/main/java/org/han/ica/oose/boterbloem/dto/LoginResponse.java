package org.han.ica.oose.boterbloem.dto;

/**
 * Representative DTO for a LoginResponse
 */
public class LoginResponse {
    private String user;
    private String token;
    private String administratorLevel;

    public LoginResponse(String user, String token, String administratorLevel) {
        this.user = user;
        this.token = token;
        this.administratorLevel = administratorLevel;
    }
}
