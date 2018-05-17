package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientCareInstitution")
public class ClientCareInstitutionEntity {

    @Id
    int clientId;

    @Id
    int careInstitutionId;

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
