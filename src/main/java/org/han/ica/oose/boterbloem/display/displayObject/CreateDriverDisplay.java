package org.han.ica.oose.boterbloem.display.displayObject;

import org.han.ica.oose.boterbloem.dataAccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataAccess.entities.DrivercarEntity;

import java.util.ArrayList;

public class CreateDriverDisplay {
    DriverEntity driver;
    DrivercarEntity drivercarEntity;
    private int careInstitutionId;
    ArrayList<String> limitationEntities;

    public ArrayList<String> getLimitationEntities() {
        return limitationEntities;
    }

    public void setLimitationEntities(ArrayList<String> limitationEntities) {
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
