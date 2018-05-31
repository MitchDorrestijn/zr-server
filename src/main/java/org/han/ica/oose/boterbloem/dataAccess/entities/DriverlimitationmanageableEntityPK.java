package org.han.ica.oose.boterbloem.dataAccess.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DriverlimitationmanageableEntityPK implements Serializable {
    private int driverId;
    private String limitation;

    @Column(name = "driverId")
    @Id
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Column(name = "limitation")
    @Id
    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverlimitationmanageableEntityPK that = (DriverlimitationmanageableEntityPK) o;

        if (driverId != that.driverId) return false;
        if (limitation != null ? !limitation.equals(that.limitation) : that.limitation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + (limitation != null ? limitation.hashCode() : 0);
        return result;
    }
}
