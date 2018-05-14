package org.han.ica.oose.boterbloem.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    public Float getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(Float totalEarned) {
        this.totalEarned = totalEarned;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(int totalRides) {
        this.totalRides = totalRides;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}