package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driverCar")
public class DriverCarEntity {

    @Id
    int driverId;

    @Id
    @Column(name = "utility")
    String utility;

    @Column(name = "numberPlate")
    String numberPlate;

    @Column(name = "numberOfPassengers")
    int numberOfPassengers;

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
     * Getter for property 'numberPlate'.
     *
     * @return Value for property 'numberPlate'.
     */
    public String getNumberPlate() {
        return numberPlate;
    }

    /**
     * Setter for property 'numberPlate'.
     *
     * @param numberPlate Value to set for property 'numberPlate'.
     */
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    /**
     * Getter for property 'numberOfPassengers'.
     *
     * @return Value for property 'numberOfPassengers'.
     */
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /**
     * Setter for property 'numberOfPassengers'.
     *
     * @param numberOfPassengers Value to set for property 'numberOfPassengers'.
     */
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
