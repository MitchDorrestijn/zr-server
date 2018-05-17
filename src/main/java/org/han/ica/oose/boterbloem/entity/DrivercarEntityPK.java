package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DrivercarEntityPK implements Serializable {
    private int driverId;
    private String utility;

    @Column(name = "driverId")
    @Id
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Column(name = "utility")
    @Id
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

        DrivercarEntityPK that = (DrivercarEntityPK) o;

        if (driverId != that.driverId) return false;
        if (utility != null ? !utility.equals(that.utility) : that.utility != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + (utility != null ? utility.hashCode() : 0);
        return result;
    }
}
