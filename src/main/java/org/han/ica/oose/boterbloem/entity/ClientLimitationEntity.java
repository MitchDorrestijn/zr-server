package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientLimitation", schema = "zorgrit")
@IdClass(ClientlimitationEntityPK.class)
public class ClientLimitationEntity {
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

        ClientLimitationEntity that = (ClientLimitationEntity) o;

        if (clientId != that.clientId) return false;
        return limitation != null ? limitation.equals(that.limitation) : that.limitation == null;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (limitation != null ? limitation.hashCode() : 0);
        return result;
    }
}
