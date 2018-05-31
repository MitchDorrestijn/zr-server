package org.han.ica.oose.boterbloem.display.displayObject;

import org.han.ica.oose.boterbloem.dataAccess.entities.UtilityEntity;

import java.sql.Timestamp;

public class CreateRideDisplay {
    private int clientId;
    private int driverId;
    private Timestamp date;
    private String pickUpLocation;
    private String dropOffLocation;
    private int numberOfcompanions;
    private int numberOfLuggage;
    private UtilityEntity utilityEntity;
    private byte returnRide;
    private byte callService;
    private byte fixedRide;

    /**
     * Getter for property 'clientId'.
     *
     * @return Value for property 'clientId'.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Setter for property 'clientId'.
     *
     * @param clientId Value to set for property 'clientId'.
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Getter for property 'driverId'.
     *
     * @return Value for property 'driverId'.
     */
    public int getDriverId() {
        return driverId;
    }

    /**
     * Setter for property 'driverId'.
     *
     * @param driverId Value to set for property 'driverId'.
     */
    public void setDriverId(int driverId) {
        this.driverId = driverId;
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
     * Getter for property 'numberOfcompanions'.
     *
     * @return Value for property 'numberOfcompanions'.
     */
    public int getNumberOfcompanions() {
        return numberOfcompanions;
    }

    /**
     * Setter for property 'numberOfcompanions'.
     *
     * @param numberOfcompanions Value to set for property 'numberOfcompanions'.
     */
    public void setNumberOfcompanions(int numberOfcompanions) {
        this.numberOfcompanions = numberOfcompanions;
    }

    /**
     * Getter for property 'numberOfLuggage'.
     *
     * @return Value for property 'numberOfLuggage'.
     */
    public int getNumberOfLuggage() {
        return numberOfLuggage;
    }

    /**
     * Setter for property 'numberOfLuggage'.
     *
     * @param numberOfLuggage Value to set for property 'numberOfLuggage'.
     */
    public void setNumberOfLuggage(int numberOfLuggage) {
        this.numberOfLuggage = numberOfLuggage;
    }

    /**
     * Getter for property 'utilityEntity'.
     *
     * @return Value for property 'utilityEntity'.
     */
    public UtilityEntity getUtilityEntity() {
        return utilityEntity;
    }

    /**
     * Setter for property 'utilityEntity'.
     *
     * @param utilityEntity Value to set for property 'utilityEntity'.
     */
    public void setUtilityEntity(UtilityEntity utilityEntity) {
        this.utilityEntity = utilityEntity;
    }

    /**
     * Getter for property 'returnRide'.
     *
     * @return Value for property 'returnRide'.
     */
    public byte getReturnRide() {
        return returnRide;
    }

    /**
     * Setter for property 'returnRide'.
     *
     * @param returnRide Value to set for property 'returnRide'.
     */
    public void setReturnRide(byte returnRide) {
        this.returnRide = returnRide;
    }

    /**
     * Getter for property 'callService'.
     *
     * @return Value for property 'callService'.
     */
    public byte getCallService() {
        return callService;
    }

    /**
     * Setter for property 'callService'.
     *
     * @param callService Value to set for property 'callService'.
     */
    public void setCallService(byte callService) {
        this.callService = callService;
    }

    /**
     * Getter for property 'fixedRide'.
     *
     * @return Value for property 'fixedRide'.
     */
    public byte getFixedRide() {
        return fixedRide;
    }

    /**
     * Setter for property 'fixedRide'.
     *
     * @param fixedRide Value to set for property 'fixedRide'.
     */
    public void setFixedRide(byte fixedRide) {
        this.fixedRide = fixedRide;
    }
}
