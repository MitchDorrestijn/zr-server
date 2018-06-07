package org.han.ica.oose.boterbloem.controller;

import org.han.ica.oose.boterbloem.dataaccess.entities.RideEntity;
import org.han.ica.oose.boterbloem.display.displayobject.CreateRideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.RideOverviewDisplay;
import org.han.ica.oose.boterbloem.security.AdminAndCareInstitutionAuthorization;
import org.han.ica.oose.boterbloem.security.AdminAuthorization;
import org.han.ica.oose.boterbloem.display.displayobject.RidesByCareinstitutionDisplay;
import org.han.ica.oose.boterbloem.service.IRideService;
import org.han.ica.oose.boterbloem.service.serviceimplementation.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/ride")
public class RideController {

    private IRideService rideService = new RideService();

    @Autowired
    RideController() {
        // Empty Constructor for Spring
    }

    /**
     *  payments of a specific careisntitution
     * @param id of a careinstitution
     * @return display of Payments
     */
    @RequestMapping(value = "/paymentsAtCareinstitution/{id}", method = RequestMethod.GET)
    public List<RideOverviewDisplay> paymentsAtCareinstitution(@PathVariable int id) {
        return rideService.getPaymentsAtCareInstitution(id);
    }

    /**
     * GET Ride by Id
     *
     * @param id of Ride
     * @return Ride
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RideEntity getRideById(@PathVariable int id) {
        return rideService.findById(id);
    }

    /**
     * GET all Rides
     *
     * @return list of Rides
     */
    @AdminAuthorization
    @RequestMapping(value = "/getAllRides", method = RequestMethod.GET)
    public List<RideDisplay> getAllRides() {
        return rideService.getAllRides();
    }

    /**
     * GET all Ride information
     *
     * @return list of Ride information
     */
    @AdminAuthorization
    @RequestMapping(value = "/rides/overview", method = RequestMethod.GET)
    public List<RideOverviewDisplay> getRideOverview() {
        return rideService.getRideOverview();
    }

    /**
     * POST new Ride
     *
     * @param ride = new Ride
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createRide(@RequestBody CreateRideDisplay ride) {
        rideService.createRide(ride);
    }

    /**
     * DELETE Ride by Id
     *
     * @param id of Ride
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteRide(@PathVariable int id) {
        rideService.deleteRideById(id);
    }

    /**
     * Get all rides by a specific careInstitution
     * @param careId the careinstitution you want to get the rides of
     * @return a list of rides from a specific care institution
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/careinstitutionRides/{careId}", method = RequestMethod.GET)
    public List<RidesByCareinstitutionDisplay> ridesFromCareinstitution(@PathVariable int careId) {
        return rideService.getRidesFromCareInstitution(careId);
    }

    /**
     * Updates a ride
     * @param ride the ride that needs to be updated
     */
    @AdminAndCareInstitutionAuthorization
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateRide(@PathVariable CreateRideDisplay ride) {
        rideService.update(ride);

    }
}