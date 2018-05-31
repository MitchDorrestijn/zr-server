package org.han.ica.oose.boterbloem.display.displayobject;

import java.sql.Timestamp;

public class DriverRideDisplay {
    private Timestamp date;
    private String pickUpLocation;
    private String dropOffLocation;
    private String transferTo;
    private float amount;
    private String driverName;
    private String clientName;

    /**
     * Getter for property 'date'.
     *
     * @return Value for property 'date'.
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Setter for property 'date'.
     *
     * @param date Value to set for property 'date'.
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Getter for property 'pickUpLocation'.
     *
     * @return Value for property 'pickUpLocation'.
     */
    public String getPickUpLocation() {
        return pickUpLocation;
    }

    /**
     * Setter for property 'pickUpLocation'.
     *
     * @param pickUpLocation Value to set for property 'pickUpLocation'.
     */
    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    /**
     * Getter for property 'dropOffLocation'.
     *
     * @return Value for property 'dropOffLocation'.
     */
    public String getDropOffLocation() {
        return dropOffLocation;
    }

    /**
     * Setter for property 'dropOffLocation'.
     *
     * @param dropOffLocation Value to set for property 'dropOffLocation'.
     */
    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    /**
     * Getter for property 'transferTo'.
     *
     * @return Value for property 'transferTo'.
     */
    public String getTransferTo() {
        return transferTo;
    }

    /**
     * Setter for property 'transferTo'.
     *
     * @param transferTo Value to set for property 'transferTo'.
     */
    public void setTransferTo(String transferTo) {
        this.transferTo = transferTo;
    }

    /**
     * Getter for property 'amount'.
     *
     * @return Value for property 'amount'.
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Setter for property 'amount'.
     *
     * @param amount Value to set for property 'amount'.
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * Getter for property 'driverName'.
     *
     * @return Value for property 'driverName'.
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Setter for property 'driverName'.
     *
     * @param driverName Value to set for property 'driverName'.
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * Getter for property 'clientName'.
     *
     * @return Value for property 'clientName'.
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Setter for property 'clientName'.
     *
     * @param clientName Value to set for property 'clientName'.
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
