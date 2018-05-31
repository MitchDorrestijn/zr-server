package org.han.ica.oose.boterbloem.dataAccess.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DriverclientpreferenceEntityPK implements Serializable {
    private int driverId;
    private int clientId;

    @Column(name = "driverId")
    @Id
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Column(name = "clientId")
    @Id
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

        DriverclientpreferenceEntityPK that = (DriverclientpreferenceEntityPK) o;

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
