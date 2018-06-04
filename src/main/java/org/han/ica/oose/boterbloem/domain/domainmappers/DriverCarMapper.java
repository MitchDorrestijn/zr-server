package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.DriverCar;

public class DriverCarMapper {

    /**
     * Extracts drivercar from drivercarEntity
     * @param drivercarEntity
     * @return
     */
    public DriverCar extractDriverCar(DrivercarEntity drivercarEntity) {
        DriverCar driverCar = new DriverCar();

        driverCar.setNumberOfPassengers(drivercarEntity.getNumberOfPassengers());
        driverCar.setNumberPlate(drivercarEntity.getNumberPlate());
        driverCar.setSegment(drivercarEntity.getSegment());
        driverCar.setBrand(drivercarEntity.getBrand());
        driverCar.setUtility(drivercarEntity.getUtility());

        return driverCar;
    }

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
