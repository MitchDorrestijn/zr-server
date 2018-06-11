package org.han.ica.oose.boterbloem.display.displayobject;

import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;

import java.util.List;

public class CreateDriverDisplay {

    private DriverEntity driver;
    private DrivercarEntity drivercar;
    private int careInstitutionId;
    private List<String> limitations;

    public List<String> getLimitations() {
        return limitations;
    }

    public void setLimitations(List<String> limitations) {
        this.limitations = limitations;
    }

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    public DrivercarEntity getDrivercar() {
        return drivercar;
    }

    public void setDrivercar(DrivercarEntity drivercar) {
        this.drivercar = drivercar;
    }

    public int getCareInstitutionId() {
        return careInstitutionId;
    }

    public void setCareInstitutionId(int careInstitutionId) {
        this.careInstitutionId = careInstitutionId;
    }
}
