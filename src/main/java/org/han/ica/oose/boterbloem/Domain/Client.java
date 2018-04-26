package org.han.ica.oose.boterbloem.Domain;

public class Client {
    private int clientId;
    private String companion;
    private String utility;
    private boolean driverPreferenceForced;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    public boolean isDriverPreferenceF() {
        return driverPreferenceForced;
    }

    public void setDriverPreferenceF(boolean driverPreferenceF) {
        this.driverPreferenceForced = driverPreferenceF;
    }
}