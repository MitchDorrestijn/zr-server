package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDrivercarDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.DrivercarDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RideMapper {
    private static final Logger LOGGER = Logger.getLogger(RideMapper.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();

    public List<RideOverviewDisplay> getRideOverview() {
        List<RideOverviewDisplay> returnList = new ArrayList<>();
        for (RideEntity r : rideDAO.findAll()) {
            try {
                returnList.add(setRideDisplay(r));
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }
        }
        return returnList;
    }

    private RideOverviewDisplay setRideDisplay(RideEntity r) {
        RideOverviewDisplay rideOverviewDisplay = new RideOverviewDisplay();
        rideOverviewDisplay.setPaymentStatus(r.getPaymentStatus());
        try {
            rideOverviewDisplay.setId(r.getDriverEntity().getDriverId());
            rideOverviewDisplay.setDriverName(r.getDriverEntity().getUserEntity().getFirstName());
            rideOverviewDisplay.setAccountnr(r.getDriverEntity().getAccountnr());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            rideOverviewDisplay.setDriverName("Geen chauffeur gevonden");
            rideOverviewDisplay.setAccountnr("Geen bankrekening gevonden");
        }
        rideOverviewDisplay.setpriceOfRide(r.getPriceOfRide());
        rideOverviewDisplay.setPaymentDescription(r.getPaymentDescription());
        rideOverviewDisplay.setPaymentDueBefore(r.getPaymentDueBefore());
        return rideOverviewDisplay;
    }


    public List<Ride> getAllRidesByInstitution(int careId) {
        List<Ride> returnList = new ArrayList<>();
        List<RideEntity> rideEntities = rideDAO.ridesWithCareinstitution(careId);

        for (RideEntity r : rideEntities) {
            Ride ride = new Ride();
            if (r.getCallService() == 1) {
                ride.setCallService(true);
            } else {
                ride.setCallService(false);
            }
            ride.setClient(setClientNames(r.getClientEntity()));
            ride.setDriver(setDriverNames(r.getDriverEntity()));
            ride.setPickUpDateTime(r.getPickUpDateTime());
        }
    }

    /**
     * set a Driver with driverEntity
     *
     * @param driverEntity of the driver
     * @return Driver
     */
    public Driver setDriverNames(DriverEntity driverEntity) {
        Driver driver = new Driver();
        driver.setFirstName(driverEntity.getUserEntity().getFirstName());
        driver.setLastName(driverEntity.getUserEntity().getLastName());
        return driver;
    }

    /**
     * Set the driverCars of a driver
     *
     * @param driverId id of the driver
     * @return List of drivercars
     */
    private List<DriverCar> setDriverCarsByDriverId(int driverId) {
        List<DriverCar> driverCars = new ArrayList<>();
        for (DrivercarEntity driverCarEntities : drivercarDAO.drivercarEntityListByDriverId(driverId)) {
            DriverCar driverCar = new DriverCar();
            driverCar.setNumberOfPassengers(driverCarEntities.getNumberOfPassengers());
            driverCar.setNumberPlate(driverCarEntities.getNumberPlate());
            driverCar.setSegment(driverCarEntities.getSegment());
            driverCar.setBrand(driverCarEntities.getBrand());
            driverCar.setUtility(driverCarEntities.getUtility());
            driverCars.add(driverCar);
        }
        return driverCars;
    }

    /**
     * Set the client
     *
     * @param clientEntity of the client
     * @return Client
     */
    public Client setClientNames(ClientEntity clientEntity) {
        Client client = new Client();
        client.setFirstName(clientEntity.getUserEntity().getFirstName());
        client.setLastName(clientEntity.getUserEntity().getLastName());
        return client;

    }
}
