package org.han.ica.oose.boterbloem.entity;

import org.han.ica.oose.boterbloem.entity.compositeKeys.ClientCareInstitutionIdentity;

import javax.persistence.*;

@Entity
@Table(name = "clientCareInstitution")
public class ClientCareInstitutionEntity {

    @EmbeddedId
    ClientCareInstitutionIdentity clientCareInstitutionIdentity;

    /**
     * Getter for property 'clientCareInstitutionIdentity'.
     *
     * @return Value for property 'clientCareInstitutionIdentity'.
     */
    public ClientCareInstitutionIdentity getClientCareInstitutionIdentity() {
        return clientCareInstitutionIdentity;
    }

    /**
     * Setter for property 'clientCareInstitutionIdentity'.
     *
     * @param clientCareInstitutionIdentity Value to set for property 'clientCareInstitutionIdentity'.
     */
    public void setClientCareInstitutionIdentity(ClientCareInstitutionIdentity clientCareInstitutionIdentity) {
        this.clientCareInstitutionIdentity = clientCareInstitutionIdentity;
    }
}
