package org.han.ica.oose.boterbloem.service.serviceImplementation;

import org.han.ica.oose.boterbloem.domain.domainMappers.RideMapper;
import org.han.ica.oose.boterbloem.service.IRideService;
import org.han.ica.oose.boterbloem.display.displayObject.RideOverviewDisplay;

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
