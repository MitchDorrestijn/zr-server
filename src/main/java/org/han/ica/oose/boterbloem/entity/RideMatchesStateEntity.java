package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rideMatchesState")
public class RideMatchesStateEntity {

    @Id
    @Column(name = "rideId")
    int rideId;

    @Column(name = "driverId")
    int driverId;

    @Column(name = "matched")
    boolean matched;

    /**
     * Getter for property 'rideId'.
     *
     * @return Value for property 'rideId'.
     */
    public int getRideId() {
        return rideId;
    }

    /**
     * Setter for property 'rideId'.
     *
     * @param rideId Value to set for property 'rideId'.
     */
    public void setRideId(int rideId) {
        this.rideId = rideId;
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
     * Getter for property 'matched'.
     *
     * @return Value for property 'matched'.
     */
    public boolean isMatched() {
        return matched;
    }

    /**
     * Setter for property 'matched'.
     *
     * @param matched Value to set for property 'matched'.
     */
    public void setMatched(boolean matched) {
        this.matched = matched;
    }
}
