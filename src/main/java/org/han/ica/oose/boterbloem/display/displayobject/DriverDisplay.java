package org.han.ica.oose.boterbloem.display.displayobject;

import org.han.ica.oose.boterbloem.domain.domainobjects.DriverCar;

public class DriverDisplay {

    private int id;
    private String name;
    private DriverCar driverCar =  new DriverCar();
    private String typeOfPayment;
    private Float totalEarned = (float) 0;
    private int totalRides = 0;
    private int rating = 0;


    /**
     * Getter for property 'driverCar'.
     *
     * @return Value for property 'driverCar'.
     */
    public DriverCar getDriverCar() {
        return driverCar;
    }

    /**
     * Setter for property 'driverCar'.
     *
     * @param driverCar Value to set for property 'driverCar'.
     */
    public void setDriverCar(DriverCar driverCar) {
        this.driverCar = driverCar;
    }

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
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
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
     * Getter for property 'totalEarned'.
     *
     * @return Value for property 'totalEarned'.
     */
    public Float getTotalEarned() {
        return totalEarned;
    }

    /**
     * Setter for property 'totalEarned'.
     *
     * @param totalEarned Value to set for property 'totalEarned'.
     */
    public void setTotalEarned(Float totalEarned) {
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
     * Getter for property 'rating'.
     *
     * @return Value for property 'rating'.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Setter for property 'rating'.
     *
     * @param rating Value to set for property 'rating'.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
}