package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "rideproposedfordriver", schema = "zorgrit", catalog = "")
@IdClass(RideproposedfordriverEntityPK.class)
public class RideproposedfordriverEntity {
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

        RideproposedfordriverEntity that = (RideproposedfordriverEntity) o;

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
