package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IRideDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.RideDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RideMapper {
    private static final Logger LOGGER = Logger.getLogger(RideMapper.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();

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


}
