package org.han.ica.oose.boterbloem.dataaccess.daosecurity;

public class JwtUser {
    private String userName;
    private String password;
    private String role;

    /**
     * Getter for property 'userName'.
     *
     * @return Value for property 'userName'.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for property 'userName'.
     *
     * @param userName Value to set for property 'userName'.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for property 'password'.
     *
     * @return Value for property 'password'.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for property 'password'.
     *
     * @param password Value to set for property 'password'.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for property 'role'.
     *
     * @return Value for property 'role'.
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter for property 'role'.
     *
     * @param role Value to set for property 'role'.
     */
    public void setRole(String role) {
        this.role = role;
    }
}
