package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.Driver;

import java.util.List;

public interface IDriverService {

    /***
     * @return A list of all drivers and their properties
     */
    List<Driver> getAllDrivers();
}
