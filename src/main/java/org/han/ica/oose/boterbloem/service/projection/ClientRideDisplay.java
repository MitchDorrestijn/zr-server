package org.han.ica.oose.boterbloem.service.projection;

import java.sql.Date;

public class ClientRideDisplay {
    private Date date;
    private String pickupLocation;
    private String destination;
    private String driverName;
    private String clientName;
    private String clientPayment;

    /**
     * Getter for property 'date'.
     *
     * @return Value for property 'date'.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for property 'date'.
     *
     * @param date Value to set for property 'date'.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for property 'pickupLocation'.
     *
     * @return Value for property 'pickupLocation'.
     */
    public String getPickupLocation() {
        return pickupLocation;
    }

    /**
     * Setter for property 'pickupLocation'.
     *
     * @param pickupLocation Value to set for property 'pickupLocation'.
     */
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    /**
     * Getter for property 'destination'.
     *
     * @return Value for property 'destination'.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Setter for property 'destination'.
     *
     * @param destination Value to set for property 'destination'.
     */
    public void setDestination(String destination) {
        this.destination = destination;
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

    /**
     * Getter for property 'clientPayment'.
     *
     * @return Value for property 'clientPayment'.
     */
    public String getClientPayment() {
        return clientPayment;
    }

    /**
     * Setter for property 'clientPayment'.
     *
     * @param clientPayment Value to set for property 'clientPayment'.
     */
    public void setClientPayment(String clientPayment) {
        this.clientPayment = clientPayment;
    }
}
