package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "driverlimitationmanageable", schema = "zorgrit")
@IdClass(DriverlimitationmanageableEntityPK.class)
public class DriverlimitationmanageableEntity {
    private int driverId;
    private String limitation;

    @Id
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Id
    @Column(name = "limitation")
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

        DriverlimitationmanageableEntity that = (DriverlimitationmanageableEntity) o;

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
