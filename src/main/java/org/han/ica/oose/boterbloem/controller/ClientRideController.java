package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.service.ClientRideService;
import org.han.ica.oose.boterbloem.service.displays.ClientRideDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ride/client")
public class ClientRideController {

    private ClientRideService clientRideService = new ClientRideService();

    @Autowired
    public ClientRideController() {
        //Empty constructor for spring
    }

    /**
     * @param clientId of Client
     * @return list of all rides of a specific Client
     */
    @CrossOrigin
    @RequestMapping(value = "/clientRide/{clientId}", method = RequestMethod.GET)
    public List <ClientRideDisplay> getRidesFromSpecificClient(@PathVariable int clientId) {
        return clientRideService.getRidesFromSpecificClient(clientId);
    }

}
