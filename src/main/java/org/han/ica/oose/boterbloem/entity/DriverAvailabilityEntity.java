package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "driverAvailability")
public class DriverAvailabilityEntity {

    @Id
    int driverId;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "startDateTime")
    Date startDateTime;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "endDateTime")
    Date endDateTime;

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
     * Getter for property 'startDateTime'.
     *
     * @return Value for property 'startDateTime'.
     */
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * Setter for property 'startDateTime'.
     *
     * @param startDateTime Value to set for property 'startDateTime'.
     */
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * Getter for property 'endDateTime'.
     *
     * @return Value for property 'endDateTime'.
     */
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * Setter for property 'endDateTime'.
     *
     * @param endDateTime Value to set for property 'endDateTime'.
     */
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }
}
