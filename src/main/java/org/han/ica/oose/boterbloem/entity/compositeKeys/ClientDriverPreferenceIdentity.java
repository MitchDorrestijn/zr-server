package org.han.ica.oose.boterbloem.entity.compositeKeys;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Embeddable
public class ClientDriverPreferenceIdentity implements Serializable {

    @NotNull
    private
    int driverId;

    @NotNull
    private
    int clientId;


    public ClientDriverPreferenceIdentity() {

    }

    public ClientDriverPreferenceIdentity(int clientId, int driverId) {
        this.driverId = driverId;
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
}
