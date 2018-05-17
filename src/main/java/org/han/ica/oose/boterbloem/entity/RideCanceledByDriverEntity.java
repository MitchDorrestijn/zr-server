package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "rideCanceledByDriver")
public class RideCanceledByDriverEntity {

    @Id
    @Column(name = "rideId")
    int rideId;
    @Id
    @Column(name = "driverId")
    int driverId;
    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "cancelledDate")
    Date cancelledDate;

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
     * Getter for property 'cancelledDate'.
     *
     * @return Value for property 'cancelledDate'.
     */
    public Date getCancelledDate() {
        return cancelledDate;
    }

    /**
     * Setter for property 'cancelledDate'.
     *
     * @param cancelledDate Value to set for property 'cancelledDate'.
     */
    public void setCancelledDate(Date cancelledDate) {
        this.cancelledDate = cancelledDate;
    }
}
