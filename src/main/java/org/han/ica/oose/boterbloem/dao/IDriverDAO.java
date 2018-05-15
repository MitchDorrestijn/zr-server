package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Driver;

import java.util.List;

public interface IDriverDAO {

    /***
     * @return All drivers and their properties fetched from the database
     */
    List<Driver> getAllDrivers();
}