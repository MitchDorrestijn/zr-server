package org.han.ica.oose.boterbloem.service.displays;

import java.sql.Timestamp;

public class RideDisplay {
    private byte warning;
    private Timestamp date;
    private String pickUpLocation;
    private String dropOffLocation;
    private byte assignedDriver;
    private String driverName;
    private String clientName;

    /**
     * Getter for property 'warning'.
     *
     * @return Value for property 'warning'.
     */
    public byte isWarning() {
        return warning;
    }

    /**
     * Setter for property 'warning'.
     *
     * @param warning Value to set for property 'warning'.
     */
    public void setWarning(byte warning) {
        this.warning = warning;
    }

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
     * Getter for property 'assignedDriver'.
     *
     * @return Value for property 'assignedDriver'.
     */
    public byte isAssignedDriver() {
        return assignedDriver;
    }

    /**
     * Setter for property 'assignedDriver'.
     *
     * @param assignedDriver Value to set for property 'assignedDriver'.
     */
    public void setAssignedDriver(byte assignedDriver) {
        this.assignedDriver = assignedDriver;
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