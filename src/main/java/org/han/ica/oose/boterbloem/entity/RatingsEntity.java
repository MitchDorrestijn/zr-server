package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rideMatchesRejected")
public class RatingsEntity {

    @Id
    @Column(name = "clientId")
    int clientId;

    @Column(name = "driverId")
    int driverId;

    @Column(name = "beoordeling")
    String beoordeling;

    @Column(name = "sterren")
    int sterren;

    /**
     * Getter for property 'clientId'.
     *
     * @return Value for property 'clientId'.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Setter for property 'clientId'.
     *
     * @param clientId Value to set for property 'clientId'.
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

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
     * Getter for property 'beoordeling'.
     *
     * @return Value for property 'beoordeling'.
     */
    public String getBeoordeling() {
        return beoordeling;
    }

    /**
     * Setter for property 'beoordeling'.
     *
     * @param beoordeling Value to set for property 'beoordeling'.
     */
    public void setBeoordeling(String beoordeling) {
        this.beoordeling = beoordeling;
    }

    /**
     * Getter for property 'sterren'.
     *
     * @return Value for property 'sterren'.
     */
    public int getSterren() {
        return sterren;
    }

    /**
     * Setter for property 'sterren'.
     *
     * @param sterren Value to set for property 'sterren'.
     */
    public void setSterren(int sterren) {
        this.sterren = sterren;
    }
}
