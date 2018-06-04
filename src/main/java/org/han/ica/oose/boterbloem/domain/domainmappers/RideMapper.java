package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;
import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.domain.domainobjects.Ride;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RideMapper {
    private static final Logger LOGGER = Logger.getLogger(RideMapper.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();
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
        Ride ride = extractRide(rideEntity);
        return ride;
    }

    private Ride extractRide(RideEntity rideEntity) {
        Ride ride = new Ride();

        ride.setPickUpDateTime(rideEntity.getPickUpDateTime());
        ride.setPickUpLocation(rideEntity.getPickUpLocation());
        ride.setDropOffLocation(rideEntity.getDropOffLocation());
        for (int i = 0; i < rideEntity.getUtilityEntity().size(); i++) {
            Utility utility = new Utility();
            utility.setUtility(rideEntity.getUtilityEntity().get(i).getName());
            ride.addUtility(utility);
        }
        ride.setDriver(driverMapper.extractDriver(rideEntity.getDriverEntity()));
        ride.setClient(clientMapper.extractClient(rideEntity.getClientEntity()));
        ride.setPaymentDescription(rideEntity.getPaymentDescription());
        ride.setPaymentStatus(rideEntity.getPaymentStatus());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rideEntity.getPaymentDueBefore());
            ride.setPaymentDueBefore(date);
        } catch (ParseException e) {
            LOGGER.log(Level.WARNING, "Problem while parsing the date", e);
            ride.setPaymentDueBefore(null);
        }
        ride.setPriceOfRide(rideEntity.getPriceOfRide());
        ride.setNumberOfcompanions(rideEntity.getNumberOfcompanions());
        ride.setNumberOfLuggage(rideEntity.getNumberOfLuggage());
        ride.setReturnRide(rideEntity.getReturnRide());
        ride.setCallService(rideEntity.getCallService());

        return ride;
    }

    public RideEntity convertRide(Ride ride, RideEntity rideEntity) {
        rideEntity.setPickUpDateTime(ride.getPickUpDateTime());
        rideEntity.setPickUpLocation(ride.getPickUpLocation());
        rideEntity.setDropOffLocation(ride.getDropOffLocation());
        List<UtilityEntity> utilityEntities = new ArrayList<>();
        for (int i = 0; i < ride.getUtilities().size(); i++) {
            utilityEntities.add(utilityMapper.convertUtility(ride.getUtilities().get(i)));
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

    public void updateRide(Ride ride) {
        RideEntity rideEntity = rideDAO.getByClientAndDateTime(ride.getClient().getId(), ride.getPickUpDateTime());
        rideDAO.update(convertRide(ride, rideEntity));
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
}
