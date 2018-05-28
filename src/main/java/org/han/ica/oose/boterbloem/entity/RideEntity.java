package org.han.ica.oose.boterbloem.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ride", schema = "zorgrit")
public class RideEntity {
    private int id;
    private Timestamp pickUpDateTime;
    private String pickUpLocation;
    private String dropOffLocation;
    private int duration;
    private int distance;
    private int numberOfcompanions;
    private int numberOfLuggage;
    private byte returnRide;
    private byte callService;
    private Integer repeatingRideId;
    private Byte cancelledByClient;
    private byte executed;
    private DriverEntity driverEntity;
    private float priceOfRide;
    private ClientEntity clientEntity;

    @OneToOne
    @JoinColumn(name = "clientId")
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    @OneToOne
    @JoinColumn(name = "driverId")
    public DriverEntity getDriverEntity() {
        return driverEntity;
    }

    public void setDriverEntity(DriverEntity driverEntity) {
        this.driverEntity = driverEntity;
    }

    @Basic
    @Column(name = "price_of_ride")
    public float getPriceOfRide() {
        return priceOfRide;
    }


    public void setPriceOfRide(float priceOfRide) {
        this.priceOfRide = priceOfRide;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pickUpDateTime")
    public Timestamp getPickUpDateTime() {
        return pickUpDateTime;
    }

    public void setPickUpDateTime(Timestamp pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    @Basic
    @Column(name = "pickUpLocation")
    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    @Basic
    @Column(name = "dropOffLocation")
    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    @Basic
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "distance")
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "numberOfcompanions")
    public int getNumberOfcompanions() {
        return numberOfcompanions;
    }

    public void setNumberOfcompanions(int numberOfcompanions) {
        this.numberOfcompanions = numberOfcompanions;
    }

    @Basic
    @Column(name = "numberOfLuggage")
    public int getNumberOfLuggage() {
        return numberOfLuggage;
    }

    public void setNumberOfLuggage(int numberOfLuggage) {
        this.numberOfLuggage = numberOfLuggage;
    }

    @Basic
    @Column(name = "returnRide")
    public byte getReturnRide() {
        return returnRide;
    }

    public void setReturnRide(byte returnRide) {
        this.returnRide = returnRide;
    }

    @Basic
    @Column(name = "callService")
    public byte getCallService() {
        return callService;
    }

    public void setCallService(byte callService) {
        this.callService = callService;
    }

    @Basic
    @Column(name = "repeatingRideId")
    public Integer getRepeatingRideId() {
        return repeatingRideId;
    }

    public void setRepeatingRideId(Integer repeatingRideId) {
        this.repeatingRideId = repeatingRideId;
    }

    @Basic
    @Column(name = "cancelledByClient")
    public Byte getCancelledByClient() {
        return cancelledByClient;
    }

    public void setCancelledByClient(Byte cancelledByClient) {
        this.cancelledByClient = cancelledByClient;
    }

    @Basic
    @Column(name = "executed")
    public byte getExecuted() {
        return executed;
    }

    public void setExecuted(byte executed) {
        this.executed = executed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RideEntity that = (RideEntity) o;

        if (id != that.id) return false;
        if (duration != that.duration) return false;
        if (distance != that.distance) return false;
        if (numberOfcompanions != that.numberOfcompanions) return false;
        if (numberOfLuggage != that.numberOfLuggage) return false;
        if (returnRide != that.returnRide) return false;
        if (callService != that.callService) return false;
        if (executed != that.executed) return false;
        if (pickUpDateTime != null ? !pickUpDateTime.equals(that.pickUpDateTime) : that.pickUpDateTime != null)
            return false;
        if (pickUpLocation != null ? !pickUpLocation.equals(that.pickUpLocation) : that.pickUpLocation != null)
            return false;
        if (dropOffLocation != null ? !dropOffLocation.equals(that.dropOffLocation) : that.dropOffLocation != null)
            return false;
        if (repeatingRideId != null ? !repeatingRideId.equals(that.repeatingRideId) : that.repeatingRideId != null)
            return false;
        if (cancelledByClient != null ? !cancelledByClient.equals(that.cancelledByClient) : that.cancelledByClient != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pickUpDateTime != null ? pickUpDateTime.hashCode() : 0);
        result = 31 * result + (pickUpLocation != null ? pickUpLocation.hashCode() : 0);
        result = 31 * result + (dropOffLocation != null ? dropOffLocation.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + distance;
        result = 31 * result + numberOfcompanions;
        result = 31 * result + numberOfLuggage;
        result = 31 * result + (int) returnRide;
        result = 31 * result + (int) callService;
        result = 31 * result + (repeatingRideId != null ? repeatingRideId.hashCode() : 0);
        result = 31 * result + (cancelledByClient != null ? cancelledByClient.hashCode() : 0);
        result = 31 * result + (int) executed;
        return result;
    }
}
