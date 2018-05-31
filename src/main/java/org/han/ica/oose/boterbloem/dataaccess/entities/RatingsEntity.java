package org.han.ica.oose.boterbloem.dataaccess.entities;

import javax.persistence.*;

@Entity
@Table(name = "ratings", schema = "zorgrit")
@IdClass(RatingsPK.class)
public class RatingsEntity {
    private int driverId;
    private int clientId;
    private String beoordeling;
    private int sterren;

    @Id
    @Basic
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Id
    @Basic
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "beoordeling")
    public String getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(String beoordeling) {
        this.beoordeling = beoordeling;
    }

    @Basic
    @Column(name = "sterren")
    public int getSterren() {
        return sterren;
    }

    public void setSterren(int sterren) {
        this.sterren = sterren;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingsEntity that = (RatingsEntity) o;

        if (driverId != that.driverId) return false;
        if (clientId != that.clientId) return false;
        if (sterren != that.sterren) return false;
        if (beoordeling != null ? !beoordeling.equals(that.beoordeling) : that.beoordeling != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + clientId;
        result = 31 * result + (beoordeling != null ? beoordeling.hashCode() : 0);
        result = 31 * result + sterren;
        return result;
    }
}
