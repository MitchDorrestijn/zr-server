package org.han.ica.oose.boterbloem.dataaccess.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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
    private byte warning;
    private byte assignedDriver;
    private byte fixedRide;
    private List<UtilityEntity> utilityEntities;
    private String paymentDescription;
    private String paymentStatus;
    private String paymentDueBefore;

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
    @Column(name = "priceOfRide")
    public float getPriceOfRide() {
        return priceOfRide;
    }


    public void setPriceOfRide(float priceOfRide) {
        this.priceOfRide = priceOfRide;
    }

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "id", strategy = "increment")
    @GeneratedValue(generator = "id")
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

    @Basic
    @Column(name = "warning")
    public byte getWarning() {
        return warning;
    }

    public void setWarning(byte warning) {
        this.warning = warning;
    }

    @Basic
    @Column(name = "assignedDriver")
    public byte getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(byte assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    @Basic
    @Column(name = "fixedRide")
    public byte getFixedRide() {
        return fixedRide;
    }

    public void setFixedRide(byte fixedRide) {
        this.fixedRide = fixedRide;
    }

    @Transient
    @OneToMany
    @JoinColumn(name = "name")
    public List<UtilityEntity> getUtilityEntities() {
        return utilityEntities;
    }

    /**
     * Setter for property 'utilityEntities'.
     *
     * @param utilityEntities Value to set for property 'utilityEntities'.
     */
    @Transient
    public void setUtilityEntities(List<UtilityEntity> utilityEntities) {
        this.utilityEntities = utilityEntities;
    }

    public void addUtilityEntity(UtilityEntity utilityEntity) {
        this.utilityEntities.add(utilityEntity);
    }

    @Column(name = "paymentDescription")
    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    @Basic
    @Column(name = "paymentStatus")
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    @Basic
    @Column(name = "paymentDueBefore")
    public String getPaymentDueBefore() {
        return paymentDueBefore;
    }

    public void setPaymentDueBefore(String paymentDueBefore) {
        this.paymentDueBefore = paymentDueBefore;
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
        if (warning != that.warning) return false;
        if (assignedDriver != that.assignedDriver) return false;
        if (fixedRide != that.fixedRide) return false;
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
        if (paymentDescription != null ? !paymentDescription.equals(that.paymentDescription) : that.paymentDescription != null)
            return false;
        if (paymentDueBefore != null ? !paymentDueBefore.equals(that.paymentDueBefore) : that.paymentDueBefore != null)
            return false;
        if (paymentStatus != null ? !paymentStatus.equals(that.paymentStatus) : that.paymentStatus != null)
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
        result = 31 * result + (int) warning;
        result = 31 * result + (int) assignedDriver;
        result = 31 * result + (int) fixedRide;
        result = 31 * result + (paymentDescription != null ? paymentDescription.hashCode() : 0);
        result = 31 * result + (paymentStatus != null ? paymentStatus.hashCode() : 0);
        result = 31 * result + (paymentDueBefore != null ? paymentDueBefore.hashCode() : 0);

        return result;
    }
}
