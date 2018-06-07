package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.DriverDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;
import org.han.ica.oose.boterbloem.display.displaymapper.RideDisplayMapper;
import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RidesByCareinstitutionDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.RideMapper;

import org.han.ica.oose.boterbloem.domain.domainmappers.UtilityMapper;

import org.han.ica.oose.boterbloem.service.IRideService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class RideService implements IRideService {
    private static final Logger LOGGER = Logger.getLogger(RideService.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();
    private IClientDAO clientDAO = new ClientDAOImpl();
    private IDriverDAO driverDAO = new DriverDAOImpl();
    private RideMapper rideMapper = new RideMapper();
    private UtilityMapper utilityMapper = new UtilityMapper();
    private RideDisplayMapper rideDisplayMapper = new RideDisplayMapper();

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
    public List<RideDisplay> getAllRides() {
        List<RideDisplay> rideDisplay = new ArrayList<>();
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
                    display.setDriverId(ride.getDriverEntity().getDriverId());
                } catch (NullPointerException e) {
                    display.setDriverName("Geen chauffeur gevonden");
                }
                rideDisplay.add(display);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return rideDisplay;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RideOverviewDisplay> getRideOverview() {
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

            List<UtilityEntity> utilityEntities = new ArrayList<>();
            for (int i = 0; i < createRideDisplay.getUtilityEntity().size(); i++) {
                utilityEntities.add(utilityMapper.convertUtility(createRideDisplay.getUtilityEntity().get(i)));
            }
            rideEntity.setUtilityEntities(utilityEntities);

            rideEntity.setReturnRide(createRideDisplay.getReturnRide());
            rideEntity.setCallService(createRideDisplay.getCallService());
            rideEntity.setFixedRide(createRideDisplay.getFixedRide());

            rideDAO.add(rideEntity);

        } catch (Exception e) {
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
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    @Override
    public void update(CreateRideDisplay ride) {
        RideDisplayMapper rideDisplayMapper = new RideDisplayMapper();
        try {
            rideDisplayMapper.updateRide(ride);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    @Override
    public List<RidesByCareinstitutionDisplay> getRidesFromCareInstitution(int careId) {
        return rideDisplayMapper.getAllRidesByInstitution(careId);
    }
}
