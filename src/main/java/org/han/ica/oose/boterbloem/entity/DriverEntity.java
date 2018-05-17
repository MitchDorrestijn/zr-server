package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "driver", schema = "zorgrit", catalog = "")
public class DriverEntity {
    private int driverId;
    private byte verification;
    private String utility;

    @Id
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "verification")
    public byte getVerification() {
        return verification;
    }

    public void setVerification(byte verification) {
        this.verification = verification;
    }

    @Basic
    @Column(name = "utility")
    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverEntity that = (DriverEntity) o;

        if (driverId != that.driverId) return false;
        if (verification != that.verification) return false;
        if (utility != null ? !utility.equals(that.utility) : that.utility != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + (int) verification;
        result = 31 * result + (utility != null ? utility.hashCode() : 0);
        return result;
    }
}
