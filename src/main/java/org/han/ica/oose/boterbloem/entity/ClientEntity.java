package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    int clientId;

    @Column(name = "companion")
    String companion;

    @Column(name = "utility")
    String utility;

    @Column(name = "driverPreferenceForced")
    Boolean driverPreferenceForced;


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
     * Getter for property 'companion'.
     *
     * @return Value for property 'companion'.
     */
    public String getCompanion() {
        return companion;
    }

    /**
     * Setter for property 'companion'.
     *
     * @param companion Value to set for property 'companion'.
     */
    public void setCompanion(String companion) {
        this.companion = companion;
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
     * Getter for property 'driverPreferenceForced'.
     *
     * @return Value for property 'driverPreferenceForced'.
     */
    public Boolean getDriverPreferenceForced() {
        return driverPreferenceForced;
    }

    /**
     * Setter for property 'driverPreferenceForced'.
     *
     * @param driverPreferenceForced Value to set for property 'driverPreferenceForced'.
     */
    public void setDriverPreferenceForced(Boolean driverPreferenceForced) {
        this.driverPreferenceForced = driverPreferenceForced;
    }
}
