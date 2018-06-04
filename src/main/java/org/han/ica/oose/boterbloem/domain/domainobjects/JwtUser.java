package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.AuthUsersDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;
import org.mindrot.jbcrypt.BCrypt;

public class JwtUser {
    private String userName;
    private String password;
    private String role;
    private int careInstitutionId;
    private String latestToken;
    private IAuthUsersDAO authUsersDAO = new AuthUsersDAOImpl();

    /**
     * Getter for property 'careInstitutionId'.
     *
     * @return Value for property 'careInstitutionId'.
     */
    public int getCareInstitutionId() {
        return careInstitutionId;
    }

    /**
     * Setter for property 'careInstitutionId'.
     *
     * @param careInstitutionId Value to set for property 'careInstitutionId'.
     */
    public void setCareInstitutionId(int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }

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

    /**
     * Getter for property 'latestToken'.
     *
     * @return Value for property 'latestToken'.
     */
    public String getLatestToken() {
        return latestToken;
    }

    /**
     * Setter for property 'latestToken'.
     *
     * @param latestToken Value to set for property 'latestToken'.
     */
    public void setLatestToken(String latestToken) {
        this.latestToken = latestToken;
    }

    public void saveAuthenticatedUser(JwtUser jwtUser){
        AuthUsersEntity authUsersEntity = new AuthUsersEntity();
        authUsersEntity.setUserName(jwtUser.getUserName());
        authUsersEntity.setPassword(BCrypt.hashpw(jwtUser.getPassword(), BCrypt.gensalt()));
        authUsersEntity.setRole(jwtUser.getRole());
        authUsersEntity.setCareInstitutionId(jwtUser.getCareInstitutionId());
        authUsersEntity.setLatestToken(jwtUser.getLatestToken());
        authUsersDAO.add(authUsersEntity);
    }

    public void updateToken(JwtUser jwtUser) {
        AuthUsersEntity authUsersEntity = new AuthUsersEntity();
        authUsersEntity.setUserName(jwtUser.getUserName());
        authUsersEntity.setPassword(BCrypt.hashpw(jwtUser.getPassword(), BCrypt.gensalt()));
        authUsersEntity.setRole(jwtUser.getRole());
        authUsersEntity.setCareInstitutionId(jwtUser.getCareInstitutionId());
        authUsersEntity.setLatestToken(jwtUser.getLatestToken());
        authUsersDAO.update(authUsersEntity);
    }
}
