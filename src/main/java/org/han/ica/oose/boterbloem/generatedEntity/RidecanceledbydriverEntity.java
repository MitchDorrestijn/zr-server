package org.han.ica.oose.boterbloem.generatedEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ridecanceledbydriver", schema = "zorgrit", catalog = "")
@IdClass(RidecanceledbydriverEntityPK.class)
public class RidecanceledbydriverEntity {
    private int rideId;
    private int driverId;
    private Timestamp cancelledDate;

    @Id
    @Column(name = "rideId")
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    @Id
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Id
    @Column(name = "cancelledDate")
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

        RidecanceledbydriverEntity that = (RidecanceledbydriverEntity) o;

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
