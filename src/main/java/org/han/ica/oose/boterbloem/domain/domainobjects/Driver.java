package org.han.ica.oose.boterbloem.domain.domainobjects;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User {

    private int id;
    private byte verification; //  VOG verified
    private String typeOfPayment; //
    private String image; //   copy of driver's licence
    private String accountnr; // bank account number for payment purposes
    private List<DriverCar> driverCars =  new ArrayList<>();
    private float totalEarned;
    private int totalRides;


    /**
     * Getter for property 'driverCars'.
     *
     * @return Value for property 'driverCars'.
     */
    public List<DriverCar> getDriverCars() {
        return driverCars;
    }

    /**
     * Setter for property 'driverCars'.
     *
     * @param driverCars Value to set for property 'driverCars'.
     */
    public void setDriverCars(List<DriverCar> driverCars) {
        this.driverCars = driverCars;
    }

    /**
     * Getter for property 'totalEarned'.
     *
     * @return Value for property 'totalEarned'.
     */
    public float getTotalEarned() {
        return totalEarned;
    }

    /**
     * Setter for property 'totalEarned'.
     *
     * @param totalEarned Value to set for property 'totalEarned'.
     */
    public void setTotalEarned(float totalEarned) {
        this.totalEarned = totalEarned;
    }

    /**
     * Getter for property 'totalRides'.
     *
     * @return Value for property 'totalRides'.
     */
    public int getTotalRides() {
        return totalRides;
    }

    /**
     * Setter for property 'totalRides'.
     *
     * @param totalRides Value to set for property 'totalRides'.
     */
    public void setTotalRides(int totalRides) {
        this.totalRides = totalRides;
    }

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
     * Getter for property 'typeOfPayment'.
     *
     * @return Value for property 'typeOfPayment'.
     */
    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    /**
     * Setter for property 'typeOfPayment'.
     *
     * @param typeOfPayment Value to set for property 'typeOfPayment'.
     */
    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
