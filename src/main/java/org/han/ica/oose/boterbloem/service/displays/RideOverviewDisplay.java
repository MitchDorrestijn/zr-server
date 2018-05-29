package org.han.ica.oose.boterbloem.service.displays;

import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.RideEntity;

public class RideOverviewDisplay {
    private DriverEntity driverEntity;
    private RideEntity rideEntity;

    /**
     * Getter for the property driver
     * @return driverEntity
     */
    public DriverEntity getDriverEntity() {
        return driverEntity;
    }

    /**
     * Setter for the property driver
     * @param driverEntity Value to set for property 'driverEntity'.
     */
    public void setDriverEntity(DriverEntity driverEntity) {
        this.driverEntity = driverEntity;
    }

    /**
     * Getter for the property ride
     * @return rideEntity
     */
    public RideEntity getRideEntity() {
        return rideEntity;
    }

    /**
     * Setter for the property ride
     * @param rideEntity Value to set for property 'rideEntity'.
     */
    public void setRideEntity(RideEntity rideEntity) {
        this.rideEntity = rideEntity;
    }
}
