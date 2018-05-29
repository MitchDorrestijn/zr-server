package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.mapper.RideMapper;
import org.han.ica.oose.boterbloem.service.displays.RideOverviewDisplay;

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
