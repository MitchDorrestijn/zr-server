package org.han.ica.oose.boterbloem.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representative domain class for a Client
 */
public class Client {
    private int clientId;
    private String companion;
    private String utility;
    private boolean driverPreferenceForced;
    private int PKB;
    private int Total_Meters;
    private String name;
    private boolean warningPKB;
    private double priceToPay;

    @JsonCreator
    public Client(
            @JsonProperty("name") String name,
            @JsonProperty("PKB") int PKB,
            @JsonProperty("warningPKB") boolean warningPKB,
            @JsonProperty("priceToPay") double priceToPay,
            @JsonProperty("Total_Meters") int Total_Meters)
    {
        this.name = name;
        this.PKB = PKB;
        this.warningPKB = warningPKB;
        this.priceToPay = priceToPay;
        this.Total_Meters = Total_Meters;
    }

    public Client(){
        // empty constructor
    }

    /**
     * Getter for property 'clientId'.
     *
     * @return Value for property 'clientId'.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Setter for property 'clientId'.
     *
     * @param clientId Value to set for property 'clientId'.
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Getter for property 'companion'.
     *
     * @return Value for property 'companion'.
     */
    public String getCompanion() {
        return companion;
    }

    /**
     * Setter for property 'companion'.
     *
     * @param companion Value to set for property 'companion'.
     */
    public void setCompanion(String companion) {
        this.companion = companion;
    }

    /**
     * Getter for property 'utility'.
     *
     * @return Value for property 'utility'.
     */
    public String getUtility() {
        return utility;
    }

    /**
     * Setter for property 'utility'.
     *
     * @param utility Value to set for property 'utility'.
     */
    public void setUtility(String utility) {
        this.utility = utility;
    }

    /**
     * Getter for property 'driverPreferenceF'.
     *
     * @return Value for property 'driverPreferenceF'.
     */
    public boolean isDriverPreferenceF() {
        return driverPreferenceForced;
    }

    /**
     * Setter for property 'driverPreferenceF'.
     *
     * @param driverPreferenceF Value to set for property 'driverPreferenceF'.
     */
    public void setDriverPreferenceF(boolean driverPreferenceF) {
        this.driverPreferenceForced = driverPreferenceF;
    }

    public int getTotal_Meters() {
        return Total_Meters;
    }

    public void setTotal_Meters(int total_Meters) {
        Total_Meters = total_Meters;
    }

    public int getPKB() {
        return PKB;
    }

    public void setPKB(int PKB) {
        this.PKB = PKB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWarningPKB() {
        return warningPKB;
    }

    public void setWarningPKB(boolean warningPKB) {
        this.warningPKB = warningPKB;
    }

    public double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(double priceToPay) {
        this.priceToPay = priceToPay;
    }
}