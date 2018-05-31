package org.han.ica.oose.boterbloem.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RidematchesrejectedEntityPK implements Serializable {
    private int rideId;
    private int driverId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RidematchesrejectedEntityPK that = (RidematchesrejectedEntityPK) o;

        if (rideId != that.rideId) return false;
        if (driverId != that.driverId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rideId;
        result = 31 * result + driverId;
        return result;
    }
}
