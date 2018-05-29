package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.service.displays.ClientRideDisplay;

import java.util.List;

public interface IClientRideService {
    List<ClientRideDisplay> getRidesFromSpecificClient(int clientId);
}
