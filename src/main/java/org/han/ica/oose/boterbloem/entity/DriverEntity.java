package org.han.ica.oose.boterbloem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class DriverEntity {

    @Id
    int driverId;

    @Column(name = "verification")
    private
    boolean verification;

    @Id
    @Column(name = "utility")
    private
    String utility;

    @Column(name = "type_of_payment")
    private
    String type_of_payment;

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
     * Getter for property 'verification'.
     *
     * @return Value for property 'verification'.
     */
    public boolean isVerification() {
        return verification;
    }

    /**
     * Setter for property 'verification'.
     *
     * @param verification Value to set for property 'verification'.
     */
    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    /**
     * Getter for property 'utility'.
     *
     * @return Value for property 'utility'.
     */
    public String getUtility() {
        return utility;
    }

    /**
     * Setter for property 'utility'.
     *
     * @param utility Value to set for property 'utility'.
     */
    public void setUtility(String utility) {
        this.utility = utility;
    }

    /**
     * Getter for property 'type_of_payment'.
     *
     * @return Value for property 'type_of_payment'.
     */
    public String getType_of_payment() {
        return type_of_payment;
    }

    /**
     * Setter for property 'type_of_payment'.
     *
     * @param type_of_payment Value to set for property 'type_of_payment'.
     */
    public void setType_of_payment(String type_of_payment) {
        this.type_of_payment = type_of_payment;
    }
}
