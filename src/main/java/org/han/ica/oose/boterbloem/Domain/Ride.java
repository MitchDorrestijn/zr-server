package org.han.ica.oose.boterbloem.Domain;

import java.util.Date;

public class Ride {
    private int id;
    private int clientId;
    private int driverId;
    private int preferedCareInstitution;
    private int preferedDriver;
    private Date pickUpDateTime;
    private String pickUpLocation;
    private String dropOffLocation;
    private int duration;
    private int distance;
    private int numerOfCompanions;
    private int numerOfLuggage;
    private boolean returnRide;
    private boolean callService;
    private String utility;
    private int repeatingRideId;
    private boolean cancelledByClient;
    private boolean executed;
}
