package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dataAccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.display.displayObject.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.display.displayObject.DriverDisplay;

import java.util.List;

public interface IDriverService {

    /***
     * @return A list of all drivers and their properties
     */
    List<DrivercarEntity> getAllDrivers();

    void deleteDriver(int id, int idcare);

    int getCareInstitutionId(int id);

    void updateDriver(CreateDriverDisplay createDriverDisplay);


    /**
     * @param id - The id of the care institution
     * @return a list of all drivers from a specific care institutions
     */
    List<DriverDisplay> getAllDriversFromASpecificCareInstitution(int id);

    /**
     * @return a list of all drivers from all care institutions
     */
    List<DriverDisplay> allDriversWithStatistics();
}
