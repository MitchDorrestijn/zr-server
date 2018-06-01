package org.han.ica.oose.boterbloem.domain.domainobjects;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Ride {
    private LocalDateTime pickUpDateTime;
    private Location pickUpLocation;
    private Location dropOffLocation;
    private List<Utility> utilities;
    private Driver driver;
    private Client client;
    private String paymentDescription;
    private String paymentStatus;
    private Date paymentDueBefore;
    private float price_of_ride;
    private int numberOfcompanions; //How many people are in the car besides the driver + client
    private int numberOfLuggage;
    private boolean returnRide;
    private boolean callService;

    /**
     * Getter for property 'pickUpDateTime'.
     *
     * @return Value for property 'pickUpDateTime'.
     */
    public LocalDateTime getPickUpDateTime() {
        return pickUpDateTime;
    }

    /**
     * Setter for property 'pickUpDateTime'.
     *
     * @param pickUpDateTime Value to set for property 'pickUpDateTime'.
     */
    public void setPickUpDateTime(LocalDateTime pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    /**
     * Getter for property 'pickUpLocation'.
     *
     * @return Value for property 'pickUpLocation'.
     */
    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    /**
     * Setter for property 'pickUpLocation'.
     *
     * @param pickUpLocation Value to set for property 'pickUpLocation'.
     */
    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    /**
     * Getter for property 'dropOffLocation'.
     *
     * @return Value for property 'dropOffLocation'.
     */
    public Location getDropOffLocation() {
        return dropOffLocation;
    }

    /**
     * Setter for property 'dropOffLocation'.
     *
     * @param dropOffLocation Value to set for property 'dropOffLocation'.
     */
    public void setDropOffLocation(Location dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    /**
     * Getter for property 'utilities'.
     *
     * @return Value for property 'utilities'.
     */
    public List<Utility> getUtilities() {
        return utilities;
    }

    /**
     * Setter for property 'utilities'.
     *
     * @param utilities Value to set for property 'utilities'.
     */
    public void setUtilities(List<Utility> utilities) {
        this.utilities = utilities;
    }

    /**
     * Getter for property 'driver'.
     *
     * @return Value for property 'driver'.
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Setter for property 'driver'.
     *
     * @param driver Value to set for property 'driver'.
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * Getter for property 'client'.
     *
     * @return Value for property 'client'.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Setter for property 'client'.
     *
     * @param client Value to set for property 'client'.
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Getter for property 'paymentDescription'.
     *
     * @return Value for property 'paymentDescription'.
     */
    public String getPaymentDescription() {
        return paymentDescription;
    }

    /**
     * Setter for property 'paymentDescription'.
     *
     * @param paymentDescription Value to set for property 'paymentDescription'.
     */
    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    /**
     * Getter for property 'paymentStatus'.
     *
     * @return Value for property 'paymentStatus'.
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Setter for property 'paymentStatus'.
     *
     * @param paymentStatus Value to set for property 'paymentStatus'.
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * Getter for property 'paymentDueBefore'.
     *
     * @return Value for property 'paymentDueBefore'.
     */
    public Date getPaymentDueBefore() {
        return paymentDueBefore;
    }

    /**
     * Setter for property 'paymentDueBefore'.
     *
     * @param paymentDueBefore Value to set for property 'paymentDueBefore'.
     */
    public void setPaymentDueBefore(Date paymentDueBefore) {
        this.paymentDueBefore = paymentDueBefore;
    }

    /**
     * Getter for property 'price_of_ride'.
     *
     * @return Value for property 'price_of_ride'.
     */
    public float getPrice_of_ride() {
        return price_of_ride;
    }

    /**
     * Setter for property 'price_of_ride'.
     *
     * @param price_of_ride Value to set for property 'price_of_ride'.
     */
    public void setPrice_of_ride(float price_of_ride) {
        this.price_of_ride = price_of_ride;
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
}