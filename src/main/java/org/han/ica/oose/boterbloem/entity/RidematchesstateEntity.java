package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "ridematchesstate", schema = "zorgrit", catalog = "")
public class RidematchesstateEntity {
    private int rideId;
    private String status;
    private byte matched;

    @Id
    @Column(name = "rideId")
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "matched")
    public byte getMatched() {
        return matched;
    }

    public void setMatched(byte matched) {
        this.matched = matched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RidematchesstateEntity that = (RidematchesstateEntity) o;

        if (rideId != that.rideId) return false;
        if (matched != that.matched) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rideId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (int) matched;
        return result;
    }
}
