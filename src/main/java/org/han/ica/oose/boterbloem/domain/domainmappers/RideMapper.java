package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IDrivercarDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.DrivercarDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;
import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.DriverCar;
import org.han.ica.oose.boterbloem.domain.domainobjects.Ride;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RideMapper {
    private static final Logger LOGGER = Logger.getLogger(RideMapper.class.getName());

    private IRideDAO rideDAO = new RideDAOImpl();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();
    private UtilityMapper utilityMapper = new UtilityMapper();
    private DriverMapper driverMapper = new DriverMapper();
    private ClientMapper clientMapper = new ClientMapper();


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

    public Ride getRide(CreateRideDisplay rideDisplay) {
        RideEntity rideEntity = rideDAO.getByClientAndDateTime(rideDisplay.getClientId(), rideDisplay.getDate());
        return extractRide(rideEntity);

    }

    /**
     * Extracts ride object from ride entity
     *
     * @param rideEntity
     * @return
     */
    private Ride extractRide(RideEntity rideEntity) {
        Ride ride = new Ride();
        try {
            setRideDataOfRideEntity(rideEntity, ride);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        try {
            ride.setPaymentDueBefore(rideEntity.getPaymentDueBefore());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Problem while parsing the date", e);
            ride.setPaymentDueBefore(null);
        }
        try {
            setDetailedDataOfRideEntity(rideEntity, ride);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return ride;
    }

    private void setDetailedDataOfRideEntity(RideEntity rideEntity, Ride ride) {
        ride.setPriceOfRide(rideEntity.getPriceOfRide());
        ride.setNumberOfcompanions(rideEntity.getNumberOfcompanions());
        ride.setNumberOfLuggage(rideEntity.getNumberOfLuggage());
        ride.setReturnRide(rideEntity.getReturnRide());
        ride.setCallService(rideEntity.getCallService());
    }

    private void setRideDataOfRideEntity(RideEntity rideEntity, Ride ride) {
        ride.setPickUpDateTime(rideEntity.getPickUpDateTime());
        ride.setPickUpLocation(rideEntity.getPickUpLocation());
        ride.setDropOffLocation(rideEntity.getDropOffLocation());
        ride.setDriver(driverMapper.extractDriver(rideEntity.getDriverEntity()));
        ride.setClient(clientMapper.extractClient(rideEntity.getClientEntity()));
        ride.setPaymentDescription(rideEntity.getPaymentDescription());
        ride.setPaymentStatus(rideEntity.getPaymentStatus());
        for (UtilityEntity utilityEntity : rideEntity.getUtilityEntities()) {
            ride.addUtility(utilityMapper.extractUtility(utilityEntity));
        }
    }


    /**
     * Converts ride to rideEntity
     *
     * @param ride
     * @param rideEntity
     * @return
     */
    public RideEntity convertRide(Ride ride, RideEntity rideEntity) {
        rideEntity.setPickUpDateTime(ride.getPickUpDateTime());
        rideEntity.setPickUpLocation(ride.getPickUpLocation());
        rideEntity.setDropOffLocation(ride.getDropOffLocation());
        List<UtilityEntity> utilityEntities = new ArrayList<>();
        for (Utility utility : ride.getUtilities()) {
            utilityEntities.add(utilityMapper.convertUtility(utility));
        }
        rideEntity.setUtilityEntities(utilityEntities);
        rideEntity.setClientEntity(clientMapper.convertClient(ride.getClient()));
        rideEntity.setDriverEntity(driverMapper.convertDriver(ride.getDriver()));
        rideEntity.setPaymentDescription(ride.getPaymentDescription());
        rideEntity.setPaymentStatus(ride.getPaymentStatus());
        rideEntity.setPaymentDueBefore(ride.getPaymentDueBefore().toString());
        rideEntity.setPriceOfRide(ride.getPriceOfRide());
        rideEntity.setNumberOfcompanions(ride.getNumberOfcompanions());
        rideEntity.setNumberOfLuggage(ride.getNumberOfLuggage());
        rideEntity.setReturnRide(ride.isReturnRide());
        rideEntity.setCallService(ride.isCallService());
        return rideEntity;
    }

    /**
     * Updates ride in the database
     *
     * @param ride
     */
    public void updateRide(Ride ride) {
        RideEntity rideEntity = rideDAO.getByClientAndDateTime(ride.getClient().getId(), ride.getPickUpDateTime());
        rideDAO.update(convertRide(ride, rideEntity));
    }

    /**
     * Puts all required information into ridedisplay
     *
     * @param r
     * @return
     */
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


    /**
     * @param careId careisntitution id
     * @return all (Domein) rides from a careisntitution
     */
    public List<Ride> getAllRidesByInstitution(int careId) {
        List<RideEntity> rideEntities = rideDAO.ridesWithCareinstitution(careId);
        List<Ride> rides = new ArrayList<>();
        for (RideEntity rideEntity : rideEntities) {
            try {
                rides.add(extractRide(rideEntity));
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }
        }
        return rides;
    }

    /**
     * Setter for property 'rideDAO'.
     *
     * @param rideDAO Value to set for property 'rideDAO'.
     */
    public void setRideDAO(IRideDAO rideDAO) {
        this.rideDAO = rideDAO;
    }

    /**
     * Setter for property 'drivercarDAO'.
     *
     * @param drivercarDAO Value to set for property 'drivercarDAO'.
     */
    public void setDrivercarDAO(IDrivercarDAO drivercarDAO) {
        this.drivercarDAO = drivercarDAO;
    }

    /**
     * Setter for property 'utilityMapper'.
     *
     * @param utilityMapper Value to set for property 'utilityMapper'.
     */
    public void setUtilityMapper(UtilityMapper utilityMapper) {
        this.utilityMapper = utilityMapper;
    }

    /**
     * Setter for property 'driverMapper'.
     *
     * @param driverMapper Value to set for property 'driverMapper'.
     */
    public void setDriverMapper(DriverMapper driverMapper) {
        this.driverMapper = driverMapper;
    }

    /**
     * Setter for property 'clientMapper'.
     *
     * @param clientMapper Value to set for property 'clientMapper'.
     */
    public void setClientMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }
}
