package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "driverCareInstitution")
public class DriverCareInstitutionEntity {

    @Id
    int driverId;

    @Id
    int careInstitutionId;

    /**
     * Getter for property 'driverId'.
     *
     * @return Value for property 'driverId'.
     */
    public int getDriverId() {
        return driverId;
    }

    /**
     * Setter for property 'driverId'.
     *
     * @param driverId Value to set for property 'driverId'.
     */
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    /**
     * Getter for property 'careInstitutionId'.
     *
     * @return Value for property 'careInstitutionId'.
     */
    public int getCareInstitutionId() {
        return careInstitutionId;
    }

    /**
     * Setter for property 'careInstitutionId'.
     *
     * @param careInstitutionId Value to set for property 'careInstitutionId'.
     */
    public void setCareInstitutionId(int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }
}
