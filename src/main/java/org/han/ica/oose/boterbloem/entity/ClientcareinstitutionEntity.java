package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientcareinstitution", schema = "zorgrit", catalog = "")
@IdClass(ClientcareinstitutionEntityPK.class)
public class ClientcareinstitutionEntity {
    private int clientId;
    private int careInstitutionId;

    @Id
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Id
    @Column(name = "careInstitutionId")
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

        ClientcareinstitutionEntity that = (ClientcareinstitutionEntity) o;

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
