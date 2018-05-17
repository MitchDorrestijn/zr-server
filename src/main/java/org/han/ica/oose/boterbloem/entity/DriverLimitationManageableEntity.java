package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "driverLimitationManageable")
public class DriverLimitationManageableEntity {

    @Id
    int driverId;

    @Id
    @Column(name = "limitation")
    String limitation;

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
     * Getter for property 'limitation'.
     *
     * @return Value for property 'limitation'.
     */
    public String getLimitation() {
        return limitation;
    }

    /**
     * Setter for property 'limitation'.
     *
     * @param limitation Value to set for property 'limitation'.
     */
    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }
}
