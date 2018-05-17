package org.han.ica.oose.boterbloem.generatedEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

public class RidecanceledbydriverEntityPK implements Serializable {
    private int rideId;
    private int driverId;
    private Timestamp cancelledDate;

    @Column(name = "rideId")
    @Id
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    @Column(name = "driverId")
    @Id
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Column(name = "cancelledDate")
    @Id
    public Timestamp getCancelledDate() {
        return cancelledDate;
    }

    public void setCancelledDate(Timestamp cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RidecanceledbydriverEntityPK that = (RidecanceledbydriverEntityPK) o;

        if (rideId != that.rideId) return false;
        if (driverId != that.driverId) return false;
        if (cancelledDate != null ? !cancelledDate.equals(that.cancelledDate) : that.cancelledDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rideId;
        result = 31 * result + driverId;
        result = 31 * result + (cancelledDate != null ? cancelledDate.hashCode() : 0);
        return result;
    }
}
