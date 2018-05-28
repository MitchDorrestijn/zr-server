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
    private int totalMeters;
    private String name;
    private boolean warningPKB;
    private double priceToPay;

    @JsonCreator
    public Client(
            @JsonProperty("id") int clientId,
            @JsonProperty("name") String name,
            @JsonProperty("PKB") int PKB,
            @JsonProperty("warningPKB") boolean warningPKB,
            @JsonProperty("priceToPay") double priceToPay,
            @JsonProperty("totalMeters") int totalMeters)
    {
        this.clientId = clientId;
        this.name = name;
        this.PKB = PKB;
        this.warningPKB = warningPKB;
        this.priceToPay = priceToPay;
        this.totalMeters = totalMeters;
    }

    public Client(){
        // empty constructor
    }

    public Client(int clientId, String companion, String utility, boolean driverPreferenceForced) {
        this.clientId = clientId;
        this.companion = companion;
        this.utility = utility;
        this.driverPreferenceForced = driverPreferenceForced;
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

    /**
     * Getter for the property 'totalMeters'
     * @return Value of property 'totalMeters'
     */
    public int getTotalMeters() {
        return totalMeters;
    }

    /**
     * Setter for the propert 'totalMeters'
     * @param totalMeters Value to set of property 'totalMeters'
     */
    public void setTotalMeters(int totalMeters) {
        this.totalMeters = totalMeters;
    }

    /**
     * Getter for the property 'PKB'
     * @return Value of property 'PKB'
     */
    public int getPKB() {
        return PKB;
    }

    /**
     * Setter for the property 'PKB'
     * @param PKB Value to set of property 'PKB'
     */
    public void setPKB(int PKB) {
        this.PKB = PKB;
    }

    /**
     * Getter for the property 'name'
     * @return Value of property 'name'
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the property 'name'
     * @param name Value to set of property 'name'
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the property 'warningPKB'
     * @return Value of warningPKB
     */
    public boolean isWarningPKB() {
        return warningPKB;
    }

    /**
     * Setter for the property 'warningPKB'
     * @param warningPKB Value to set of property 'warningPKB'
     */
    public void setWarningPKB(boolean warningPKB) {
        this.warningPKB = warningPKB;
    }

    /**
     * Getter for the property 'priceToPay'
     * @return Value of property "priceToPay'
     */
    public double getPriceToPay() {
        return priceToPay;
    }

    /**
     * Setter for the property 'priceToPay'
     * @param priceToPay Value to set of property 'priceToPay'
     */
    public void setPriceToPay(double priceToPay) {
        this.priceToPay = priceToPay;
    }
}