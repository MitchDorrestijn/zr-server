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

    /**
     * Getter for propery 'user'
     *
     * @return Value for property 'user'
     */
    public String getUser() {
        return user;
    }

    /**
     * Setter for property 'user'.
     *
     * @param user Value to set for property 'user'.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Getter for property 'token'
     *
     * @return Value for property 'token'
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter for property 'token'
     *
     * @param token Value to set for property 'token'
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter for property 'administratorLevel'
     *
     * @return Value for property 'administratorLevel'
     */
    public String getAdministratorLevel() {
        return administratorLevel;
    }

    /**
     * Setter for property 'administratorLevel'
     *
     * @param administratorLevel Value to set property 'administratorLevel'
     */
    public void setAdministratorLevel(String administratorLevel) {
        this.administratorLevel = administratorLevel;
    }
}
