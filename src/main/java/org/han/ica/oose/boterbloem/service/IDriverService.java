package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.entity.DrivercarEntity;

import java.util.List;

public interface IDriverService {

    /***
     * @return A list of all drivers and their properties
     */
    List<DrivercarEntity> getAllDrivers();
}
