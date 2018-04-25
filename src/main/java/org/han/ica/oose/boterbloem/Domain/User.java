package org.han.ica.oose.boterbloem.Domain;

import java.util.Date;

/**
 * User who uses the system
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String Street;
    private int houseNumber;
    private int zipCode;
    private String residence;
    private String password;
    private String passwordSalt;
    private Date dateOfBirth;
    private boolean firstTimeProfileChec;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(int id) {
        this.id = id;
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
     * Getter for property 'street'.
     *
     * @return Value for property 'street'.
     */
    public String getStreet() {
        return Street;
    }

    /**
     * Setter for property 'street'.
     *
     * @param street Value to set for property 'street'.
     */
    public void setStreet(String street) {
        Street = street;
    }

    /**
     * Getter for property 'houseNumber'.
     *
     * @return Value for property 'houseNumber'.
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * Setter for property 'houseNumber'.
     *
     * @param houseNumber Value to set for property 'houseNumber'.
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Getter for property 'zipCode'.
     *
     * @return Value for property 'zipCode'.
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Setter for property 'zipCode'.
     *
     * @param zipCode Value to set for property 'zipCode'.
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Getter for property 'residence'.
     *
     * @return Value for property 'residence'.
     */
    public String getResidence() {
        return residence;
    }

    /**
     * Setter for property 'residence'.
     *
     * @param residence Value to set for property 'residence'.
     */
    public void setResidence(String residence) {
        this.residence = residence;
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
     * Getter for property 'passwordSalt'.
     *
     * @return Value for property 'passwordSalt'.
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * Setter for property 'passwordSalt'.
     *
     * @param passwordSalt Value to set for property 'passwordSalt'.
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
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
     * Getter for property 'firstTimeProfileChec'.
     *
     * @return Value for property 'firstTimeProfileChec'.
     */
    public boolean isFirstTimeProfileChec() {
        return firstTimeProfileChec;
    }

    /**
     * Setter for property 'firstTimeProfileChec'.
     *
     * @param firstTimeProfileChec Value to set for property 'firstTimeProfileChec'.
     */
    public void setFirstTimeProfileChec(boolean firstTimeProfileChec) {
        this.firstTimeProfileChec = firstTimeProfileChec;
    }
}
