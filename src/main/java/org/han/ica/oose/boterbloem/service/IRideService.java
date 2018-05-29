package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.service.displays.RideOverviewDisplay;

import java.util.List;

public interface IRideService {
    List<RideOverviewDisplay> getRideOverview();
}
