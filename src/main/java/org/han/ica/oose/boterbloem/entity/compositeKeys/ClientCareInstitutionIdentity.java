package org.han.ica.oose.boterbloem.entity.compositeKeys;


import javax.persistence.Embeddable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class ClientCareInstitutionIdentity implements Serializable {

    @NotNull
    private
    int clientId;

    @NotNull
    private
    int careInstitutionId;

    public ClientCareInstitutionIdentity() {

    }

    public ClientCareInstitutionIdentity(int clientId, int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
        this.clientId = clientId;

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
