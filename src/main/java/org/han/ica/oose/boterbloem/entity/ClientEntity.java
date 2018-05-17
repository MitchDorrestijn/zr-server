package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    private
    int clientId;

    @Column(name = "companion")
    private
    String companion;

    @Column(name = "driverPreferenceForced")
    private
    Boolean driverPreferenceForced;

    @ManyToOne
    @JoinColumn(name = "id", nullable = true)
    UserEntity user;


    @ManyToOne
    @JoinColumn(name = "utility", nullable = true)
    UtilityEntity utility;

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
