package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.display.displayobject.ClientRideDisplay;

import java.util.List;

public interface IClientRideService {
    /**
     * GET all Rides by a specific Client
     * @param id of Client
     * @return list of Client-rides
     */
    List <ClientRideDisplay> getRidesFromSpecificClientById(int id);
}
