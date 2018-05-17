package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "drivercar", schema = "zorgrit", catalog = "")
@IdClass(DrivercarEntityPK.class)
public class DrivercarEntity {
    private int driverId;
    private String utility;
    private String numberPlate;
    private int numberOfPassengers;

    @Id
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Id
    @Column(name = "utility")
    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    @Basic
    @Column(name = "numberPlate")
    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Basic
    @Column(name = "numberOfPassengers")
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrivercarEntity that = (DrivercarEntity) o;

        if (driverId != that.driverId) return false;
        if (numberOfPassengers != that.numberOfPassengers) return false;
        if (utility != null ? !utility.equals(that.utility) : that.utility != null) return false;
        if (numberPlate != null ? !numberPlate.equals(that.numberPlate) : that.numberPlate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + (utility != null ? utility.hashCode() : 0);
        result = 31 * result + (numberPlate != null ? numberPlate.hashCode() : 0);
        result = 31 * result + numberOfPassengers;
        return result;
    }
}
