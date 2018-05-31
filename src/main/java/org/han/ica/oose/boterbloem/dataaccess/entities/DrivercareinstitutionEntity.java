package org.han.ica.oose.boterbloem.dataaccess.entities;

import javax.persistence.*;

@Entity
@Table(name = "drivercareinstitution", schema = "zorgrit")
@IdClass(DrivercareinstitutionEntityPK.class)
public class DrivercareinstitutionEntity {
    private int driverId;
    private int careInstitutionId;
    private boolean active = true;

    @Column (name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
    @Column(name = "careInstitutionId")
    public int getCareInstitutionId() {
        return careInstitutionId;
    }

    public void setCareInstitutionId(int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrivercareinstitutionEntity that = (DrivercareinstitutionEntity) o;

        if (driverId != that.driverId) return false;
        if (careInstitutionId != that.careInstitutionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + careInstitutionId;
        return result;
    }
}
