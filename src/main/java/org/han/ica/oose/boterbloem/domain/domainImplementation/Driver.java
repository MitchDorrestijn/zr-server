package org.han.ica.oose.boterbloem.domain.domainImplementation;

import org.han.ica.oose.boterbloem.domain.IDriver;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User implements IDriver {

    private byte verification; //  VOG verified
    private String type_of_payment; //
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
    @Override
    public List<DriverCar> getDriverCars() {
        return driverCars;
    }

    /**
     * Setter for property 'driverCars'.
     *
     * @param driverCars Value to set for property 'driverCars'.
     */
    @Override
    public void setDriverCars(List<DriverCar> driverCars) {
        this.driverCars = driverCars;
    }

    /**
     * Getter for property 'totalEarned'.
     *
     * @return Value for property 'totalEarned'.
     */
    @Override
    public float getTotalEarned() {
        return totalEarned;
    }

    /**
     * Setter for property 'totalEarned'.
     *
     * @param totalEarned Value to set for property 'totalEarned'.
     */
    @Override
    public void setTotalEarned(float totalEarned) {
        this.totalEarned = totalEarned;
    }

    /**
     * Getter for property 'totalRides'.
     *
     * @return Value for property 'totalRides'.
     */
    @Override
    public int getTotalRides() {
        return totalRides;
    }

    /**
     * Setter for property 'totalRides'.
     *
     * @param totalRides Value to set for property 'totalRides'.
     */
    @Override
    public void setTotalRides(int totalRides) {
        this.totalRides = totalRides;
    }

    /**
     * Getter for property 'verification'.
     *
     * @return Value for property 'verification'.
     */
    @Override
    public byte getVerification() {
        return verification;
    }

    /**
     * Setter for property 'verification'.
     *
     * @param verification Value to set for property 'verification'.
     */
    @Override
    public void setVerification(byte verification) {
        this.verification = verification;
    }

    /**
     * Getter for property 'type_of_payment'.
     *
     * @return Value for property 'type_of_payment'.
     */
    @Override
    public String getType_of_payment() {
        return type_of_payment;
    }

    /**
     * Setter for property 'type_of_payment'.
     *
     * @param type_of_payment Value to set for property 'type_of_payment'.
     */
    @Override
    public void setType_of_payment(String type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    /**
     * Getter for property 'image'.
     *
     * @return Value for property 'image'.
     */
    @Override
    public String getImage() {
        return image;
    }

    /**
     * Setter for property 'image'.
     *
     * @param image Value to set for property 'image'.
     */
    @Override
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Getter for property 'accountnr'.
     *
     * @return Value for property 'accountnr'.
     */
    @Override
    public String getAccountnr() {
        return accountnr;
    }

    /**
     * Setter for property 'accountnr'.
     *
     * @param accountnr Value to set for property 'accountnr'.
     */
    @Override
    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }
}
