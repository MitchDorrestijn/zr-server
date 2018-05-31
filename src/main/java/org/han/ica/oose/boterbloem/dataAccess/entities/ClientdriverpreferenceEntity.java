package org.han.ica.oose.boterbloem.dataAccess.entities;

import javax.persistence.*;

@Entity
@Table(name = "clientdriverpreference", schema = "zorgrit")
@IdClass(ClientdriverpreferenceEntityPK.class)
public class ClientdriverpreferenceEntity {
    private int clientId;
    private int driverId;

    @Id
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Id
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientdriverpreferenceEntity that = (ClientdriverpreferenceEntity) o;

        if (clientId != that.clientId) return false;
        if (driverId != that.driverId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + driverId;
        return result;
    }
}
