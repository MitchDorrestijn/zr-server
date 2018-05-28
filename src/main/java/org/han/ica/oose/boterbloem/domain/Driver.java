package org.han.ica.oose.boterbloem.domain;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User{

    private byte verification; //  VOG verified
    private String type_of_payment;
    private String image; //   copy of driver's licence
    private String accountnr; // bank account number for payment purposes
    private List<DriverCar> driverCars =  new ArrayList<>();

    /**
     * Getter for property 'verification'.
     *
     * @return Value for property 'verification'.
     */
    public byte getVerification() {
        return verification;
    }

    /**
     * Setter for property 'verification'.
     *
     * @param verification Value to set for property 'verification'.
     */
    public void setVerification(byte verification) {
        this.verification = verification;
    }

    /**
     * Getter for property 'type_of_payment'.
     *
     * @return Value for property 'type_of_payment'.
     */
    public String getType_of_payment() {
        return type_of_payment;
    }

    /**
     * Setter for property 'type_of_payment'.
     *
     * @param type_of_payment Value to set for property 'type_of_payment'.
     */
    public void setType_of_payment(String type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    /**
     * Getter for property 'image'.
     *
     * @return Value for property 'image'.
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter for property 'image'.
     *
     * @param image Value to set for property 'image'.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Getter for property 'accountnr'.
     *
     * @return Value for property 'accountnr'.
     */
    public String getAccountnr() {
        return accountnr;
    }

    /**
     * Setter for property 'accountnr'.
     *
     * @param accountnr Value to set for property 'accountnr'.
     */
    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }
}
