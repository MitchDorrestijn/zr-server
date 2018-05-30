package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
import org.han.ica.oose.boterbloem.service.displays.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.service.displays.DriverDisplay;

import java.util.List;

public interface IDriverService {

    /***
     * @return A list of all drivers and their properties
     */
    List<DrivercarEntity> getAllDrivers();

    void deleteDriver(int id, int idcare);

    int getCareInstitutionId(int id);

    void updateDriver(CreateDriverDisplay createDriverDisplay);

    List<DriverDisplay> getAllDriversFromASpecificCareInstitution(int id);
}
