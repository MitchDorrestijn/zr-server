package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.display.displayobject.ClientRideDisplay;
import org.han.ica.oose.boterbloem.service.IClientRideService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.ClientRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/ride/client")
public class ClientRideController {

    private IClientRideService clientRideService = new ClientRideService();

    @Autowired
    public ClientRideController() {
        //Empty constructor for spring
    }

    /**
     * GET all Rides by a specific Client
     * @param clientId of Client
     * @return list of Clients-rides
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ZORGINSTELLING')")
    @RequestMapping(value = "/clientRide/{clientId}", method = RequestMethod.GET)
    public List <ClientRideDisplay> getRidesFromSpecificClientById(@PathVariable int clientId) {
        return clientRideService.getRidesFromSpecificClientById(clientId);
    }

}
