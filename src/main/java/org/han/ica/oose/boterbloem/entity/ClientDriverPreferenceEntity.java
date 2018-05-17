package org.han.ica.oose.boterbloem.entity;

import org.han.ica.oose.boterbloem.entity.compositeKeys.ClientDriverPreferenceIdentity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "clientDriverPreference")
public class ClientDriverPreferenceEntity {

    @EmbeddedId
    ClientDriverPreferenceIdentity clientDriverPreferenceIdentity;


    /**
     * Getter for property 'clientDriverPreferenceIdentity'.
     *
     * @return Value for property 'clientDriverPreferenceIdentity'.
     */
    public ClientDriverPreferenceIdentity getClientDriverPreferenceIdentity() {
        return clientDriverPreferenceIdentity;
    }

    /**
     * Setter for property 'clientDriverPreferenceIdentity'.
     *
     * @param clientDriverPreferenceIdentity Value to set for property 'clientDriverPreferenceIdentity'.
     */
    public void setClientDriverPreferenceIdentity(ClientDriverPreferenceIdentity clientDriverPreferenceIdentity) {
        this.clientDriverPreferenceIdentity = clientDriverPreferenceIdentity;
    }
}
