package org.han.ica.oose.boterbloem.generatedEntity;

import javax.persistence.*;

@Entity
@Table(name = "clientlimitation", schema = "zorgrit", catalog = "")
@IdClass(ClientlimitationEntityPK.class)
public class ClientlimitationEntity {
    private int clientId;
    private String limitation;

    @Id
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Id
    @Column(name = "limitation")
    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientlimitationEntity that = (ClientlimitationEntity) o;

        if (clientId != that.clientId) return false;
        if (limitation != null ? !limitation.equals(that.limitation) : that.limitation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (limitation != null ? limitation.hashCode() : 0);
        return result;
    }
}
