package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rideMatchesRejected")
public class RideMatchesRejectedEntity {

    @Id
    @Column(name = "rideId")
    int rideId;

    @Id
    @Column(name = "driverId")
    int driverId;

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
}
