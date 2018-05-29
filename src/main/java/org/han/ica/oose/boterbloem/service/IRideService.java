package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.service.displays.RideOverviewDisplay;

import java.util.List;

public interface IRideService {
    /**
     * @return A list with information of a ride
     */
    List<RideOverviewDisplay> getRideOverview();
}