package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "driveravailability", schema = "zorgrit")
@IdClass(DriveravailabilityEntityPK.class)
public class DriveravailabilityEntity {
    private int driverId;
    private Timestamp startDateTime;
    private Timestamp endDateTime;

    @Id
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Id
    @Column(name = "startDateTime")
    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Id
    @Column(name = "endDateTime")
    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriveravailabilityEntity that = (DriveravailabilityEntity) o;

        if (driverId != that.driverId) return false;
        if (startDateTime != null ? !startDateTime.equals(that.startDateTime) : that.startDateTime != null)
            return false;
        if (endDateTime != null ? !endDateTime.equals(that.endDateTime) : that.endDateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + (startDateTime != null ? startDateTime.hashCode() : 0);
        result = 31 * result + (endDateTime != null ? endDateTime.hashCode() : 0);
        return result;
    }
}
