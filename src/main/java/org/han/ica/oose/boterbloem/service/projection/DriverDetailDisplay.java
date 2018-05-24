package org.han.ica.oose.boterbloem.service.projection;

import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;

import java.util.ArrayList;
import java.util.Date;

public class DriverDetailDisplay {

    DriverEntity driver;
    DrivercarEntity drivercarEntity;
    ArrayList<String> limitationEntities;

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    public DrivercarEntity getDrivercarEntity() {
        return drivercarEntity;
    }

    public void setDrivercarEntity(DrivercarEntity drivercarEntity) {
        this.drivercarEntity = drivercarEntity;
    }

    public ArrayList<String> getLimitationEntities() {
        return limitationEntities;
    }

    public void setLimitationEntities(ArrayList<String> limitationEntities) {
        this.limitationEntities = limitationEntities;
    }
}
