package org.han.ica.oose.boterbloem.display.displayobject;

import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;

import java.util.List;

public class CreateDriverDisplay {
    DriverEntity driver;
    DrivercarEntity drivercarEntity;
    private int careInstitutionId;
    List<String> limitationEntities;

    public List<String> getLimitationEntities() {
        return limitationEntities;
    }

    public void setLimitationEntities(List<String> limitationEntities) {
        this.limitationEntities = limitationEntities;
    }

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

    public int getCareInstitutionId() {
        return careInstitutionId;
    }

    public void setCareInstitutionId(int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }
}
