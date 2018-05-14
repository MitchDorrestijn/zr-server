package org.han.ica.oose.boterbloem.dto;

/**
 * Representative DTO for a LoginRequest
 */
public class LoginRequest {

    protected String username;
    protected String password;

    public LoginRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

}
