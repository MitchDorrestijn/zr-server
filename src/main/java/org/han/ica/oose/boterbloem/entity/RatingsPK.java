package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RatingsPK implements Serializable {
    private int clientId;
    private int driverId;

    @Column(name = "clientId")
    @Id
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Column(name = "driverId")
    @Id
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

        RatingsPK that = (RatingsPK) o;

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
