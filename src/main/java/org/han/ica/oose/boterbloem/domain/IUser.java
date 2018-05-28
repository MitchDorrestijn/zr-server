package org.han.ica.oose.boterbloem.domain;

import org.han.ica.oose.boterbloem.domain.domainImplementation.Address;

import java.sql.Date;

public interface IUser {
    Address getAddress();

    void setAddress(Address address);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getPassword();

    void setPassword(String password);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

    byte getFirstTimeProfileCheck();

    void setFirstTimeProfileCheck(byte firstTimeProfileCheck);
}
