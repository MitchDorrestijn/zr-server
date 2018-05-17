package org.han.ica.oose.boterbloem.generatedEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ClientcareinstitutionEntityPK implements Serializable {
    private int clientId;
    private int careInstitutionId;

    @Column(name = "clientId")
    @Id
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Column(name = "careInstitutionId")
    @Id
    public int getCareInstitutionId() {
        return careInstitutionId;
    }

    public void setCareInstitutionId(int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientcareinstitutionEntityPK that = (ClientcareinstitutionEntityPK) o;

        if (clientId != that.clientId) return false;
        if (careInstitutionId != that.careInstitutionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + careInstitutionId;
        return result;
    }
}
