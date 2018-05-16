package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.springframework.stereotype.Component;

import java.util.List;


public interface IDriverEntityManager extends IGenericDAO<DriverEntity> {



    DriverEntity findById(int id);


    List<DriverEntity> findAllDrivers();


    void addDriver(DriverEntity driverEntity);


    void updateDriver(DriverEntity driverEntity);


    void deleteDriver(DriverEntity driverEntity);


}
