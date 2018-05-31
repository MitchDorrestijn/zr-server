package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dataAccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.display.displayObject.CreateDriverDisplay;

import java.util.List;

public interface IDriverService {

    /***
     * @return A list of all drivers and their properties
     */
    List<DrivercarEntity> getAllDrivers();

    void deleteDriver(int id, int idcare);

    int getCareInstitutionId(int id);

    void updateDriver(CreateDriverDisplay createDriverDisplay);
}
