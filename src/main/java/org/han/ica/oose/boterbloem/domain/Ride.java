package org.han.ica.oose.boterbloem.domain;

import java.util.Date;

/**
 * Representative domain class for a Ride
 */
public class Ride {
    private int id;
    private int clientId;
    private int driverId;
    private int preferedCareInstitution;
    private int preferedDriver;
    private Date pickUpDateTime;
    private String pickUpLocation;
    private String dropOffLocation;
    private int duration;
    private int distance;
    private int numberOfCompanions;
    private int numberOfLuggage;
    private boolean returnRide;
    private boolean callService;
    private String utility;
    private int repeatingRideId;
    private boolean cancelledByClient;
    private boolean executed;

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
     * Getter for property 'preferedCareInstitution'.
     *
     * @return Value for property 'preferedCareInstitution'.
     */
    public int getPreferedCareInstitution() {
        return preferedCareInstitution;
    }

    /**
     * Setter for property 'preferedCareInstitution'.
     *
     * @param preferedCareInstitution Value to set for property 'preferedCareInstitution'.
     */
    public void setPreferedCareInstitution(int preferedCareInstitution) {
        this.preferedCareInstitution = preferedCareInstitution;
    }

    /**
     * Getter for property 'preferedDriver'.
     *
     * @return Value for property 'preferedDriver'.
     */
    public int getPreferedDriver() {
        return preferedDriver;
    }

    /**
     * Setter for property 'preferedDriver'.
     *
     * @param preferedDriver Value to set for property 'preferedDriver'.
     */
    public void setPreferedDriver(int preferedDriver) {
        this.preferedDriver = preferedDriver;
    }

    /**
     * Getter for property 'pickUpDateTime'.
     *
     * @return Value for property 'pickUpDateTime'.
     */
    public Date getPickUpDateTime() {
        return pickUpDateTime;
    }

    /**
     * Setter for property 'pickUpDateTime'.
     *
     * @param pickUpDateTime Value to set for property 'pickUpDateTime'.
     */
    public void setPickUpDateTime(Date pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
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
     * Getter for property 'duration'.
     *
     * @return Value for property 'duration'.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Setter for property 'duration'.
     *
     * @param duration Value to set for property 'duration'.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Getter for property 'distance'.
     *
     * @return Value for property 'distance'.
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Setter for property 'distance'.
     *
     * @param distance Value to set for property 'distance'.
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Getter for property 'numerOfCompanions'.
     *
     * @return Value for property 'numerOfCompanions'.
     */
    public int getNumerOfCompanions() {
        return numberOfCompanions;
    }

    /**
     * Setter for property 'numerOfCompanions'.
     *
     * @param numerOfCompanions Value to set for property 'numerOfCompanions'.
     */
    public void setNumerOfCompanions(int numerOfCompanions) {
        this.numberOfCompanions = numerOfCompanions;
    }

    /**
     * Getter for property 'numerOfLuggage'.
     *
     * @return Value for property 'numerOfLuggage'.
     */
    public int getNumerOfLuggage() {
        return numberOfLuggage;
    }

    /**
     * Setter for property 'numerOfLuggage'.
     *
     * @param numerOfLuggage Value to set for property 'numerOfLuggage'.
     */
    public void setNumerOfLuggage(int numerOfLuggage) {
        this.numberOfLuggage = numerOfLuggage;
    }

    /**
     * Getter for property 'returnRide'.
     *
     * @return Value for property 'returnRide'.
     */
    public boolean isReturnRide() {
        return returnRide;
    }

    /**
     * Setter for property 'returnRide'.
     *
     * @param returnRide Value to set for property 'returnRide'.
     */
    public void setReturnRide(boolean returnRide) {
        this.returnRide = returnRide;
    }

    /**
     * Getter for property 'callService'.
     *
     * @return Value for property 'callService'.
     */
    public boolean isCallService() {
        return callService;
    }

    /**
     * Setter for property 'callService'.
     *
     * @param callService Value to set for property 'callService'.
     */
    public void setCallService(boolean callService) {
        this.callService = callService;
    }

    /**
     * Getter for property 'utility'.
     *
     * @return Value for property 'utility'.
     */
    public String getUtility() {
        return utility;
    }

    /**
     * Setter for property 'utility'.
     *
     * @param utility Value to set for property 'utility'.
     */
    public void setUtility(String utility) {
        this.utility = utility;
    }

    /**
     * Getter for property 'repeatingRideId'.
     *
     * @return Value for property 'repeatingRideId'.
     */
    public int getRepeatingRideId() {
        return repeatingRideId;
    }

    /**
     * Setter for property 'repeatingRideId'.
     *
     * @param repeatingRideId Value to set for property 'repeatingRideId'.
     */
    public void setRepeatingRideId(int repeatingRideId) {
        this.repeatingRideId = repeatingRideId;
    }

    /**
     * Getter for property 'cancelledByClient'.
     *
     * @return Value for property 'cancelledByClient'.
     */
    public boolean isCancelledByClient() {
        return cancelledByClient;
    }

    /**
     * Setter for property 'cancelledByClient'.
     *
     * @param cancelledByClient Value to set for property 'cancelledByClient'.
     */
    public void setCancelledByClient(boolean cancelledByClient) {
        this.cancelledByClient = cancelledByClient;
    }

    /**
     * Getter for property 'executed'.
     *
     * @return Value for property 'executed'.
     */
    public boolean isExecuted() {
        return executed;
    }

    /**
     * Setter for property 'executed'.
     *
     * @param executed Value to set for property 'executed'.
     */
    public void setExecuted(boolean executed) {
        this.executed = executed;
    }


}