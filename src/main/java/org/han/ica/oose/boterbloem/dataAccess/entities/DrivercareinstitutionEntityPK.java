package org.han.ica.oose.boterbloem.dataAccess.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DrivercareinstitutionEntityPK implements Serializable {
    private int driverId;
    private int careInstitutionId;

    @Column(name = "driverId")
    @Id
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Column(name = "careInstitutionId")
    @Id
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

        DrivercareinstitutionEntityPK that = (DrivercareinstitutionEntityPK) o;

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
