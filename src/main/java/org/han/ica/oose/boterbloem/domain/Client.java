package org.han.ica.oose.boterbloem.domain;

/**
 * Representative domain class for a Client
 */
public class Client {
    private int clientId;
    private String companion;
    private String utility;
    private boolean driverPreferenceForced;

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
}