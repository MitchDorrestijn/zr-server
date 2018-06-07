package org.han.ica.oose.boterbloem.dataaccess.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authUsers", schema = "zorgrit", catalog = "")
public class AuthUsersEntity {
    private String userName;
    private String password;
    private String role;
    private Integer careInstitutionId;
    private String latestToken;
  //  private String email;

    @Id
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "careInstitutionId")
    public Integer getCareInstitutionId() {
        return careInstitutionId;
    }

    public void setCareInstitutionId(Integer careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }

    @Basic
    @Column(name = "latestToken")
    public String getLatestToken() {
        return latestToken;
    }

    public void setLatestToken(String latestToken) {
        this.latestToken = latestToken;
    }

/*
    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUsersEntity that = (AuthUsersEntity) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role) &&
                Objects.equals(careInstitutionId, that.careInstitutionId) &&
                Objects.equals(latestToken, that.latestToken);// &&
           //     Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, role, careInstitutionId, latestToken); //email);
    }
}
