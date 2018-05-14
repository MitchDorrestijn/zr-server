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
    @JsonCreator
    public Client(
            @JsonProperty("PKB") int PKB,
            @JsonProperty("name") String name,
            @JsonProperty("Total_Meters") int Total_Meters)
    {
        this.PKB = PKB;
        this.Total_Meters = Total_Meters;
        this.name = name;
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
}