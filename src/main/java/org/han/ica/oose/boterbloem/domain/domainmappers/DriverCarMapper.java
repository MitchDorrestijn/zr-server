package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.DriverCar;

public class DriverCarMapper {

    /**
     * Converts drivercar to drivercarEntity
     * @param driverCar
     * @return
     */
    public DrivercarEntity convertDriverCar(DriverCar driverCar) {
        DrivercarEntity drivercarEntity = new DrivercarEntity();

        drivercarEntity.setNumberOfPassengers(driverCar.getNumberOfPassengers());
        drivercarEntity.setNumberPlate(driverCar.getNumberPlate());
        drivercarEntity.setSegment(driverCar.getSegment());
        drivercarEntity.setBrand(driverCar.getBrand());
        drivercarEntity.setUtility(drivercarEntity.getUtility());

        return drivercarEntity;
    }
}
