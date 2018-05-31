package org.han.ica.oose.boterbloem.dataaccess.entities;

import javax.persistence.*;

@Entity
@Table(name = "ridematchesrejected", schema = "zorgrit")
@IdClass(RidematchesrejectedEntityPK.class)
public class RidematchesrejectedEntity {
    private int rideId;
    private int driverId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RidematchesrejectedEntity that = (RidematchesrejectedEntity) o;

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
