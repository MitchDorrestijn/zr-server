package org.han.ica.oose.boterbloem.dataAccess.entities;

import javax.persistence.*;

@Entity
@Table(name = "driverclientpreference", schema = "zorgrit")
@IdClass(DriverclientpreferenceEntityPK.class)
public class DriverclientpreferenceEntity {
    private int driverId;
    private int clientId;

    @Id
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Id
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverclientpreferenceEntity that = (DriverclientpreferenceEntity) o;

        if (driverId != that.driverId) return false;
        if (clientId != that.clientId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + clientId;
        return result;
    }
}
