package org.han.ica.oose.boterbloem.service.projection;

import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;

import java.util.List;

public class DriverDetailDisplay {

    DriverEntity driver;
    DrivercarEntity drivercarEntity;
    private int careInstitutionId;
    List<String> limitationEntities;

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

    public List<String> getLimitationEntities() {
        return limitationEntities;
    }

    public void setLimitationEntities(List<String> limitationEntities) {
        this.limitationEntities = limitationEntities;
    }

    public int getCareInstitutionId() {
        return careInstitutionId;
    }

    public void setCareInstitutionId(int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }
}
