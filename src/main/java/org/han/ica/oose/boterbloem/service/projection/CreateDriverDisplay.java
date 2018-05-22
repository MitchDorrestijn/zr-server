package org.han.ica.oose.boterbloem.service.projection;

import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;

import java.util.ArrayList;

public class CreateDriverDisplay {
    DriverEntity driver;
    int careId;
    ArrayList<String> manageable;
    DrivercarEntity drivercarEntity;


    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    public int getCareId() {
        return careId;
    }

    public void setCareId(int careId) {
        this.careId = careId;
    }

    public ArrayList<String> getManageable() {
        return manageable;
    }

    public void setManageable(ArrayList<String> manageable) {
        this.manageable = manageable;
    }

    public DrivercarEntity getDrivercarEntity() {
        return drivercarEntity;
    }

    public void setDrivercarEntity(DrivercarEntity drivercarEntity) {
        this.drivercarEntity = drivercarEntity;
    }
}
