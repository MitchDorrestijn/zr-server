package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.serviceimplementation.ClientRideService;
import org.han.ica.oose.boterbloem.service.IClientRideService;
import org.han.ica.oose.boterbloem.display.displayobject.ClientRideDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ride/client")
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
    @RequestMapping(value = "/clientRide/{clientId}", method = RequestMethod.GET)
    public List <ClientRideDisplay> getRidesFromSpecificClientById(@PathVariable int clientId) {
        return clientRideService.getRidesFromSpecificClientById(clientId);
    }

}
