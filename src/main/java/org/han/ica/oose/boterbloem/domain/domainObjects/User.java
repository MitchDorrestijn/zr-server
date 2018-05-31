package org.han.ica.oose.boterbloem.domain.domainObjects;

import java.sql.Date;

public class User {

    private Address address;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Date dateOfBirth;
    private byte firstTimeProfileCheck;

    /**
     * Getter for property 'address'.
     *
     * @return Value for property 'address'.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for property 'address'.
     *
     * @param address Value to set for property 'address'.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for property 'firstName'.
     *
     * @return Value for property 'firstName'.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for property 'firstName'.
     *
     * @param firstName Value to set for property 'firstName'.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for property 'lastName'.
     *
     * @return Value for property 'lastName'.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for property 'lastName'.
     *
     * @param lastName Value to set for property 'lastName'.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for property 'email'.
     *
     * @return Value for property 'email'.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for property 'email'.
     *
     * @param email Value to set for property 'email'.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for property 'phoneNumber'.
     *
     * @return Value for property 'phoneNumber'.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for property 'phoneNumber'.
     *
     * @param phoneNumber Value to set for property 'phoneNumber'.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * Getter for property 'dateOfBirth'.
     *
     * @return Value for property 'dateOfBirth'.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter for property 'dateOfBirth'.
     *
     * @param dateOfBirth Value to set for property 'dateOfBirth'.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Getter for property 'firstTimeProfileCheck'.
     *
     * @return Value for property 'firstTimeProfileCheck'.
     */
    public byte getFirstTimeProfileCheck() {
        return firstTimeProfileCheck;
    }

    /**
     * Setter for property 'firstTimeProfileCheck'.
     *
     * @param firstTimeProfileCheck Value to set for property 'firstTimeProfileCheck'.
     */
    public void setFirstTimeProfileCheck(byte firstTimeProfileCheck) {
        this.firstTimeProfileCheck = firstTimeProfileCheck;
    }
}
