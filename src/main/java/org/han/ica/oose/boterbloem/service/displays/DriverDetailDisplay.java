package org.han.ica.oose.boterbloem.service.displays;

import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;

import java.util.ArrayList;

public class DriverDetailDisplay {

    DriverEntity driver;
    DrivercarEntity drivercarEntity;
    private int careInstitutionId;
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

    public int getCareInstitutionId() {
        return careInstitutionId;
    }

    public void setCareInstitutionId(int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }
}
