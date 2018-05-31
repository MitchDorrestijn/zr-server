package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.domain.domainmappers.RideMapper;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.service.IRideService;

import java.util.List;

public class RideService implements IRideService {

    private RideMapper rideMapper = new RideMapper();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RideOverviewDisplay> getRideOverview() {
        return rideMapper.getRideOverview();
    }
}
