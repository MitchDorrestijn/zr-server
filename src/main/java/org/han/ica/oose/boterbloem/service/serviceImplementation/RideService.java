package org.han.ica.oose.boterbloem.service.serviceImplementation;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation.DriverDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataAccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.domain.domainMappers.RideMapper;
import org.han.ica.oose.boterbloem.service.IRideService;
import org.han.ica.oose.boterbloem.display.displayObject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.service.displays.CreateRideDisplay;
import org.han.ica.oose.boterbloem.service.displays.RideDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RideService implements IRideService {
    private static final Logger LOGGER = Logger.getLogger(RideService.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();
    private IClientDAO clientDAO = new ClientDAOImpl();
    private IDriverDAO driverDAO = new DriverDAOImpl();
    private RideMapper rideMapper = new RideMapper();

    /**
     * {@inheritDoc}
     */
    @Override
    public RideEntity findById(int id) {
        return rideDAO.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List <RideDisplay> getAllRides() {
        List <RideDisplay> rideDisplay = new ArrayList <>();
        try {
            for (RideEntity ride : rideDAO.findAll()) {
                RideDisplay display = new RideDisplay();

                display.setWarning(ride.getWarning());
                display.setDate(ride.getPickUpDateTime());
                display.setPickUpLocation(ride.getPickUpLocation());
                display.setDropOffLocation(ride.getDropOffLocation());
                display.setAssignedDriver(ride.getAssignedDriver());

                try {
                    String driverName = ride.getDriverEntity().getUserEntity().getFirstName() + " " +
                            ride.getDriverEntity().getUserEntity().getLastName();

                    String clientName = ride.getClientEntity().getUserEntity().getFirstName() + " " +
                            ride.getClientEntity().getUserEntity().getLastName();

                    display.setDriverName(driverName);
                    display.setClientName(clientName);
                } catch ( NullPointerException e ) {
                    display.setDriverName("Geen chauffeur gevonden");
                }
                rideDisplay.add(display);
            }
        } catch ( Exception e ) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return rideDisplay;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List <RideOverviewDisplay> getRideOverview() {
        return rideMapper.getRideOverview();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createRide(CreateRideDisplay createRideDisplay) {
        try {
            RideEntity rideEntity = new RideEntity();
            rideEntity.setClientEntity(clientDAO.findById(createRideDisplay.getClientId()));
            rideEntity.setDriverEntity(driverDAO.findById(createRideDisplay.getDriverId()));

            rideEntity.setPickUpDateTime(createRideDisplay.getDate());
            rideEntity.setPickUpLocation(createRideDisplay.getPickUpLocation());
            rideEntity.setDropOffLocation(createRideDisplay.getDropOffLocation());

            rideEntity.setNumberOfcompanions(createRideDisplay.getNumberOfcompanions());
            rideEntity.setNumberOfLuggage(createRideDisplay.getNumberOfLuggage());
            rideEntity.setUtilityEntity(createRideDisplay.getUtilityEntity());

            rideEntity.setReturnRide(createRideDisplay.getReturnRide());
            rideEntity.setCallService(createRideDisplay.getCallService());
            rideEntity.setFixedRide(createRideDisplay.getFixedRide());

            rideDAO.add(rideEntity);

        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteRideById(int id) {
        try {
            RideEntity rideToRemove = rideDAO.findById(id);
            rideDAO.remove(rideToRemove);
        } catch ( Exception e ) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }
}
