package org.han.ica.oose.boterbloem.mapper;

import org.han.ica.oose.boterbloem.daoHibernate.IRideDAO;
import org.han.ica.oose.boterbloem.daoHibernate.RideDAOImpl;
import org.han.ica.oose.boterbloem.entity.RideEntity;
import org.han.ica.oose.boterbloem.service.DriverService;
import org.han.ica.oose.boterbloem.service.displays.RideOverviewDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RideMapper {
    private static final Logger LOGGER = Logger.getLogger(RideMapper.class.getName());
    private IRideDAO rideDAO = new RideDAOImpl();

    public List<RideOverviewDisplay> getRideOverview() {
        List<RideOverviewDisplay> returnList = new ArrayList<>();
        for (RideEntity r: rideDAO.findAll()) {
            try {
                RideOverviewDisplay rideOverviewDisplay = new RideOverviewDisplay();
                rideOverviewDisplay.setPaymentStatus(r.getPaymentStatus());
                try {
                    rideOverviewDisplay.setId(r.getDriverEntity().getDriverId());
                    rideOverviewDisplay.setDriverName(r.getDriverEntity().getUserEntity().getFirstName());
                    rideOverviewDisplay.setAccountnr(r.getDriverEntity().getAccountnr());
                } catch (NullPointerException e) {
                    rideOverviewDisplay.setDriverName("Geen chauffeur gevonden");
                    rideOverviewDisplay.setAccountnr("Geen bankrekening gevonden");
                }
                rideOverviewDisplay.setPrice_of_ride(r.getPriceOfRide());
                rideOverviewDisplay.setPaymentDescription(r.getPaymentDescription());
                rideOverviewDisplay.setPaymentDueBefore(r.getPaymentDueBefore());
                returnList.add(rideOverviewDisplay);
            } catch (Exception e){
                LOGGER.log(Level.WARNING,e.getMessage());
            }
        }
        return returnList;
    }
}