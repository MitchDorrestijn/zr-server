package org.han.ica.oose.boterbloem.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representative domain class for a Chauffeur
 */
public class Chauffeur {
    int id;
    String name;
    String typeOfPayment;
    Float totalEarned;
    int totalRides;
    String numberPlate;
    int numberOfPassengers;
    String segment;
    int rating;

    public Chauffeur() {
        //Empty constructor
    }

    /***
     *
     * @param id - ID of the chauffeur
     * @param name - Full name of the chauffeur
     * @param typeOfPayment - Type of payment that the chauffeur provides
     * @param totalEarned - Total balance the chauffeur earned
     * @param totalRides - Total rides the chauffeur did
     * @param numberPlate - The license plat of the car that the chauffeur drives around in
     * @param numberOfPassengers - The number of passengers that the chauffeur can take at once
     * @param segment - The segment of the car
     * @param rating - The average rating from the clients from a 0 to 5 scale
     */
    @JsonCreator
    public Chauffeur(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("typeOfPayment") String typeOfPayment,
            @JsonProperty("totalEarned") Float totalEarned,
            @JsonProperty("totalRides") int totalRides,
            @JsonProperty("numberPlate") String numberPlate,
            @JsonProperty("numberOfPassengers") int numberOfPassengers,
            @JsonProperty("segment") String segment,
            @JsonProperty("rating") int rating) {
        this.id = id;
        this.name = name;
        this.typeOfPayment = typeOfPayment;
        this.totalEarned = totalEarned;
        this.totalRides = totalRides;
        this.numberPlate = numberPlate;
        this.numberOfPassengers = numberOfPassengers;
        this.segment = segment;
        this.rating = rating;
    }

    /***
     * Getter for property 'id'.
     * @return value of the property 'id'.
     */
    public int getId() {
        return id;
    }

    /***
     * Setter for property 'id'.
     * @param id Value to set for property 'id'.
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * Getter for property 'name'.
     * @return value of the property 'name'.
     */
    public String getName() {
        return name;
    }

    /***
     * Setter for property 'name'.
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * Getter for property 'typeOfPayment'.
     * @return value of the property 'typeOfPayment'.
     */
    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    /***
     * Setter for property 'typeOfPayment'.
     * @param typeOfPayment Value to set for property 'typeOfPayment'.
     */
    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    /***
     * Getter for property 'totalEarned'.
     * @return value of the property 'totalEarned'.
     */
    public Float getTotalEarned() {
        return totalEarned;
    }

    /***
     * Setter for property 'totalEarned'.
     * @param totalEarned Value to set for property 'totalEarned'.
     */
    public void setTotalEarned(Float totalEarned) {
        this.totalEarned = totalEarned;
    }

    /***
     * Getter for property 'totalRides'.
     * @return value of the property 'totalRides'.
     */
    public int getTotalRides() {
        return totalRides;
    }

    /***
     * Setter for property 'totalRides'.
     * @param totalRides Value to set for property 'totalRides'.
     */
    public void setTotalRides(int totalRides) {
        this.totalRides = totalRides;
    }

    /***
     * Getter for property 'numberPlate'.
     * @return value of the property 'numberPlate'.
     */
    public String getNumberPlate() {
        return numberPlate;
    }

    /***
     * Setter for property 'numberPlate'.
     * @param numberPlate Value to set for property 'numberPlate'.
     */
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    /***
     * Getter for property 'numberOfPassengers'.
     * @return value of the property 'numberOfPassengers'.
     */
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /***
     * Setter for property 'numberOfPassengers'.
     * @param numberOfPassengers Value to set for property 'numberOfPassengers'.
     */
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    /***
     * Getter for property 'segment'.
     * @return value of the property 'segment'.
     */
    public String getSegment() {
        return segment;
    }

    /***
     * Setter for property 'segment'.
     * @param segment Value to set for property 'segment'.
     */
    public void setSegment(String segment) {
        this.segment = segment;
    }

    /***
     * Getter for property 'rating'.
     * @return value of the property 'rating'.
     */
    public int getRating() {
        return rating;
    }

    /***
     * Setter for property 'rating'.
     * @param rating Value to set for property 'rating'.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
}