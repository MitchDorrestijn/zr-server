package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.display.displayobject.*;

import java.util.List;

public interface IDriverService {
    /**
     * GET Driver by Id
     * @param id of Driver
     * @return Driver
     */
    DriverEntity findById(int id);

    /**
     * GET all Drivers
     * @return list of Drivers
     */
    List<DrivercarEntity> getAllDrivers();

    /**
     * GET Driver-details by specific driver
     * @param id of Driver
     * @return Driver-details
     */
    DriverDetailDisplay getDriverDetails(int id);

    /**
     * GET all Drivers with Statistics
     * @return list of Drivers
     */
    List<DriverDisplay> allDriversWithStatistics();

    /**
     * CREATE new Driver
     * @param createDriverDisplay = Driver
     */
    void createChauffeur(CreateDriverDisplay createDriverDisplay);

    /**
     * UPDATE Driver
     * @param createDriverDisplay = Driver
     */
    void updateDriver(CreateDriverDisplay createDriverDisplay);

    /**
     * DELETE Driver by Id
     * @param id of Driver
     * @param idCare of CarInstitution
     */
    void deleteDriverById(int id, int idCare);

    /**
     * GET CareInstitution by Id
     * @param id of CareInstitution
     * @return CareInstitution
     */
    int getCareInstitutionId(int id);

    /**
     * @param id - The id of the care institution
     * @return a list of all drivers from a specific care institutions
     */
    List<DriverDisplay> getAllDriversFromASpecificCareInstitution(int id);

}
